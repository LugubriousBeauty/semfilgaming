package com.mindhub.semfilgaming.Utilities;

import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentMethod {

    public static Boolean cardPaymentMethod(String cardNumber, int cvv, Double paymentAmount, String desc){
        try {
            URL url = new URL("http:/localhost:8081/api/payments");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("cardNumber", cardNumber);
            params.put("cvv", cvv);
            params.put("amount", paymentAmount);
            params.put("desc", desc);

            StringBuilder postData = new StringBuilder();
            for( Map.Entry<String, Object> param : params.entrySet()){
                if(postData.length() !=0){
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte [] postBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            for (int c = in.read(); c != -1; c = in.read()){
                System.out.println((char) c);
            }


        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
