package com.mindhub.semfilgaming.Controllers;


import com.mindhub.semfilgaming.DTOs.PurchaseApplicationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PurchaseController {

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

        return new ResponseEntity<>("Successful purchase", HttpStatus.CREATED);
    }
}
