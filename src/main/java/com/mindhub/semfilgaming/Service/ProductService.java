package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public List<Product> getAllProducts();

    public void saveProduct(Product product);
}
