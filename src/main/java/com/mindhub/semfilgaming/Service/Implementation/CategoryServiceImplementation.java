package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.Category;
import com.mindhub.semfilgaming.Repositories.CategoryRepository;
import com.mindhub.semfilgaming.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Long Id) {
        return categoryRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
