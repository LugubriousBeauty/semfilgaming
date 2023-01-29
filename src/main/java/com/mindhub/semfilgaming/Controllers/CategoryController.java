package com.mindhub.semfilgaming.Controllers;

import com.mindhub.semfilgaming.DTOs.CategoryDTO;
import com.mindhub.semfilgaming.Models.Category;
import com.mindhub.semfilgaming.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
    }

    @PostMapping("/products/category")
    public ResponseEntity<Object> newCategory(@RequestParam String categoryName){
        if(categoryName.isBlank()){
            return new ResponseEntity<>("Missing category's name", HttpStatus.CREATED);
        }
        Category newCategory = new Category(categoryName);
        categoryRepository.save(newCategory);

        return new ResponseEntity<>("Category created", HttpStatus.CREATED);
    }
}
