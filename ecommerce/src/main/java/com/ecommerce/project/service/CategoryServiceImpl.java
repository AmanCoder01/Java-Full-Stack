package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
//    private final List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst().orElse(null);
//        categories.remove(category);

        List<Category> categories = categoryRepository.findAll();

        for(Category category: categories){
            if(category.getCategoryId().equals(categoryId)){
                categoryRepository.delete(category);
                return "Category with category id "+ categoryId + " deleted successfully";
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with category id "+ categoryId + " not found");
    }

    @Override
    public String updateCategory(Category category,Long categoryId) {
        if (categoryId == null || categoryId.toString().isEmpty() ||
                category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category ID and Name must not be empty");
        }

//        for(Category category1: categories){
//            if(category1.getCategoryId().equals(categoryId)){
//                int index = categories.indexOf(category1);
//                categories.set(index,category);
//
//                return "Category updated successfully of "+ categoryId;
//            }
//        }

        List<Category> categories = categoryRepository.findAll();

        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());

            categoryRepository.save(existingCategory);
            return "Category updated successfully of ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with category id "+ categoryId + " not found");
        }
    }
}
