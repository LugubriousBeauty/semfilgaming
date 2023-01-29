package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.ProductCategory;
import com.mindhub.semfilgaming.Repositories.ProductCategoryRepository;
import com.mindhub.semfilgaming.Service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
}
