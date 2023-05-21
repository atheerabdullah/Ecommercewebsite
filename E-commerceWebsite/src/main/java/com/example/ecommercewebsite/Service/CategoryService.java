package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();


    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public Category updateCategory(String id, Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getIdCategory_Category().equals(id)) {
                categories.set(i, category);
                System.out.println("Category updated: " + category);
                return category;
            }
        }
        System.out.println("Category not found with ID: " + id);
        return null;
    }

    public Category deleteCategory(String id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getIdCategory_Category().equals(id)) {
                Category deletedCategory = categories.remove(i);
                System.out.println("Category removed with ID: " + id);
                return deletedCategory;
            }
        }
        System.out.println("Category not found with ID: " + id);
        return null;
    }

}
