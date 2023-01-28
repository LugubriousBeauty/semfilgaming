package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.ProductCategory;

public class ProductCategoryDTO {

    private CategoryDTO categoryDTO;

    public ProductCategoryDTO(ProductCategory productCategory){

        this.categoryDTO = new CategoryDTO(productCategory.getCategory());
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }


}
