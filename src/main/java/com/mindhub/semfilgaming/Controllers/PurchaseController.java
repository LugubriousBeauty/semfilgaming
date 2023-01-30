package com.mindhub.semfilgaming.Controllers;


import com.mindhub.semfilgaming.DTOs.ProductPurchaseApplicationDTO;
import com.mindhub.semfilgaming.DTOs.PurchaseApplicationDTO;
import com.mindhub.semfilgaming.DTOs.PurchaseDTO;
import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Models.ClientPurchase;
import com.mindhub.semfilgaming.Models.Product;
import com.mindhub.semfilgaming.Models.Purchase;
import com.mindhub.semfilgaming.Repositories.ProductRepository;
import com.mindhub.semfilgaming.Service.ClientPurchaseService;
import com.mindhub.semfilgaming.Service.ClientService;
import com.mindhub.semfilgaming.Service.ProductService;
import com.mindhub.semfilgaming.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/purchase")
    public List<PurchaseDTO> getAllPurchase(){
        return purchaseService.getAllPurchase().stream()
                .map(purchase -> new PurchaseDTO(purchase))
                .collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/purchase")
    public ResponseEntity<Object> purchasingProducts(Authentication authentication,
                                                     @RequestBody PurchaseApplicationDTO purchaseApplicationDTO){

        Client tempClient = clientService.getClientByEmail(authentication.getName());

        //------------ Comprobamos que los datos no esten vacios -------

        if(purchaseApplicationDTO.equals(null)){
            return new ResponseEntity<>("Something is wrong, please recharge the app", HttpStatus.FORBIDDEN);
        }
        if (purchaseApplicationDTO.getListProductPurchase().isEmpty()){
            return new ResponseEntity<>("Please choose at least one product", HttpStatus.FORBIDDEN);
        }
        if(purchaseApplicationDTO.getAccepted().equals(false)){
            return new ResponseEntity<>("Something is wrong with the payment's method", HttpStatus.FORBIDDEN);
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
            selectedProduct.setStock(selectedProduct.getStock()-tempPurchase.getProductQuantity());
            selectedProduct.setSalesHistory(selectedProduct.getSalesHistory()+tempPurchase.getProductQuantity());
            productService.saveProduct(selectedProduct);
        });

        // ---- seteamos el valor total de la compra ------

        tempClientPurchase.setTotalAmount(
                tempClientPurchase.getPurchases()
                        .stream()
                        .map(purchase -> purchase.getAmountPayment())
                        .reduce((aDouble, aDouble2) -> aDouble + aDouble2).orElse(0D));
        clientPurchaseService.saveClientPurchase(tempClientPurchase);

//        String tempdesc = "Purchase realized on " + LocalDate.now() + " thanks for buying in our store";

//        Boolean aprov = cardPaymentMethod( purchaseApplicationDTO.getCardNumber(),
//                purchaseApplicationDTO.getCvv(),
//                tempClientPurchase.getTotalAmount(), tempdesc);


        return new ResponseEntity<>("Successful purchase", HttpStatus.CREATED);

    }
}
