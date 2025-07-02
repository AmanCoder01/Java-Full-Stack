package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final List<Category> categories = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst().orElse(null);
//        categories.remove(category);

        for(Category category: categories){
            if(category.getCategoryId().equals(categoryId)){
                categories.remove(category);
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

        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());

            return "Category updated successfully of ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with category id "+ categoryId + " not found");
        }
    }
}
