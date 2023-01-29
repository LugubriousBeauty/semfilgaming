package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.Product;
import com.mindhub.semfilgaming.Repositories.ProductRepository;
import com.mindhub.semfilgaming.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long Id) {
        return productRepository.findById(Id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
