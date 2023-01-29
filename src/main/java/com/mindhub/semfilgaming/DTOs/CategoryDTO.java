package com.mindhub.semfilgaming.DTOs;

import com.mindhub.semfilgaming.Models.Category;

public class CategoryDTO {

    private Long Id;

    private String categoryName;

    public CategoryDTO(Category category){
        this.categoryName = category.getCategoryName();
        this.Id = category.getId();
    }

    public Long getId() {
        return Id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
