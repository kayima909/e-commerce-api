package com.example.ecommerce;

import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.exception.ResourceNotFoundException;


import java.util.List;

@Service
public class CategoryService {
    private  final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException( "Category with id " + id + " does not exist");
        }
        categoryRepository.deleteById(id);
    }
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("this"+ id + " does not exist"));
    }
    public Category updateCategory(Long id,Category category){
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(category.getId() + " does not exist"));
        existing.setName(category.getName());
        existing.setDescription(category.getDescription());
        return categoryRepository.save(existing);

    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}


