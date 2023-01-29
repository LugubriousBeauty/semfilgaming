package com.mindhub.semfilgaming.Controllers;


import com.mindhub.semfilgaming.DTOs.ProductPurchaseApplicationDTO;
import com.mindhub.semfilgaming.DTOs.PurchaseApplicationDTO;
import com.mindhub.semfilgaming.Models.ClientPurchase;
import com.mindhub.semfilgaming.Models.Product;
import com.mindhub.semfilgaming.Models.Purchase;
import com.mindhub.semfilgaming.Service.ClientPurchaseService;
import com.mindhub.semfilgaming.Service.ProductService;
import com.mindhub.semfilgaming.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientPurchaseService clientPurchaseService;

    @Transactional
    @PostMapping("/purchase")
    public ResponseEntity<Object> purchasingProducts(@RequestBody PurchaseApplicationDTO purchaseApplicationDTO){

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
        clientPurchaseService.saveClientPurchase(tempClientPurchase);

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

        tempClientPurchase.setTotalAmount(
                tempClientPurchase.getPurchases()
                        .stream()
                        .map(purchase -> purchase.getAmountPayment())
                        .reduce((aDouble, aDouble2) -> aDouble + aDouble2).orElse(0D));
        clientPurchaseService.saveClientPurchase(tempClientPurchase);

        return new ResponseEntity<>("Successful purchase", HttpStatus.CREATED);
    }
}
