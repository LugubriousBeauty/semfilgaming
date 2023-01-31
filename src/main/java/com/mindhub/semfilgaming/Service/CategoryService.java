package com.mindhub.semfilgaming.Service;

import com.mindhub.semfilgaming.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    public Category findCategoryById(Long Id);

    public List<Category> getAllCategories();

    public void saveCategory(Category category);
}
