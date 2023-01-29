package com.mindhub.semfilgaming.Controllers;


import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.mindhub.semfilgaming.DTOs.ProductPurchaseApplicationDTO;
import com.mindhub.semfilgaming.DTOs.PurchaseApplicationDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Models.ClientPurchase;
import com.mindhub.semfilgaming.Models.Product;
import com.mindhub.semfilgaming.Models.Purchase;
import com.mindhub.semfilgaming.Service.ClientPurchaseService;
import com.mindhub.semfilgaming.Service.ClientService;
import com.mindhub.semfilgaming.Service.ProductService;
import com.mindhub.semfilgaming.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientPurchaseService clientPurchaseService;

    @Autowired
    ClientService clientService;

    @Transactional
    @PostMapping("/purchase")
    public ResponseEntity<Object> purchasingProducts(Authentication authentication,
                                                     @RequestBody PurchaseApplicationDTO purchaseApplicationDTO) throws IOException {

        Client tempClient = clientService.getClientByEmail(authentication.getName());

        //------------ Comprobamos que los datos no esten vacios -------

        if(purchaseApplicationDTO.equals(null)){
            return new ResponseEntity<>("Something is wrong, please recharge the app", HttpStatus.FORBIDDEN);
        }
        if(purchaseApplicationDTO.getCardNumber().isBlank()){
            return new ResponseEntity<>("Card number can't be empty", HttpStatus.FORBIDDEN);
        }
        if(purchaseApplicationDTO.getCvv()==0){
            return  new ResponseEntity<>("Cvv is missing", HttpStatus.FORBIDDEN);
        }
        if (purchaseApplicationDTO.getListProductPurchase().isEmpty()){
            return new ResponseEntity<>("Please choose at least one product", HttpStatus.FORBIDDEN);
        }

        //------- Creamos la Instancia de compra -----

        Double amountPayment = 0D;
        ClientPurchase tempClientPurchase = new ClientPurchase(LocalDateTime.now(), amountPayment);
        tempClient.addClientPurchase(tempClientPurchase);
        clientPurchaseService.saveClientPurchase(tempClientPurchase);
        clientService.saveClient(tempClient);


        //------------ Persistencia de datos de ProductPurchase -----------

        List<ProductPurchaseApplicationDTO> listProductPurchase = purchaseApplicationDTO.getListProductPurchase();

        listProductPurchase.forEach(productPurchase -> {

            //----Buscamos el producto en el service primero
            Product selectedProduct = productService.getProductById(productPurchase.getProductId());

            // ----- Creamos la nueva instancia de compra -----
            Purchase tempPurchase = new Purchase(
                    selectedProduct.getPrice()*productPurchase.getProductQuantity(),
                    productPurchase.getProductQuantity()
            );
            purchaseService.savePurchaseProduct(tempPurchase);
            selectedProduct.addPurchase(tempPurchase);
            tempClientPurchase.addPurchase(tempPurchase);
            clientPurchaseService.saveClientPurchase(tempClientPurchase);

        });

        // ---- seteamos el valor total de la compra ------
        Double amount = tempClientPurchase.getPurchases()
                .stream()
                .map(purchase -> purchase.getAmountPayment())
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2).orElse(0D);
        tempClientPurchase.setTotalAmount(amount);
        clientPurchaseService.saveClientPurchase(tempClientPurchase);

        // ---- creamos el PDF del ticket ----------- //
        downloadPdf(listProductPurchase, amount);

        return new ResponseEntity<>("Successful purchase", HttpStatus.CREATED);
    }

    private ByteArrayInputStream createPdf(List<ProductPurchaseApplicationDTO> listProductPurchase, Double amount) throws IOException {
        // Creating a PDF document
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();

        // Creating a table
        Table table = new Table(4);
        table.setWidth(100);
        table.setBorderWidth(1);
        table.setPadding(5);

        // Adding cells to the table
        table.addCell("Product");
        table.addCell("Quantity");
        table.addCell("Price per product");

        listProductPurchase.forEach(product -> {
            Product currentProduct = productService.getProductById(product.getProductId());
            String productQuantity = String.valueOf(product.getProductQuantity());
            table.addCell(currentProduct.toString());
            table.addCell(productQuantity);
            table.addCell(currentProduct.getPrice().toString());
        });

        document.add(table);

        // Closing the document
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ResponseEntity<InputStreamResource> downloadPdf(List<ProductPurchaseApplicationDTO> listProductPurchase, Double amount) throws IOException {
        ByteArrayInputStream bis = createPdf(listProductPurchase, amount); // call the method that creates the pdf

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=table.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
