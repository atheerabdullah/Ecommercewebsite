package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CategoryController {


        private final CategoryService categoryService;

        @GetMapping("/getCategory")
        public ApiResponse getCategories() {
            categoryService.getCategories();
            return (new ApiResponse("All Categories in the stock :" + "  "
                    + categoryService.getCategories()));
        }

        @PostMapping("/addCategory")
        public Category addCategory(@Valid @RequestBody Category category) {
            categoryService.addCategory(category);
            return category;

        }
        @PutMapping("/{id}/updateCategory")
        public ResponseEntity<Category> updateCategory(@PathVariable String id, @Valid @RequestBody Category category) {
            Category updatedCategory = categoryService.updateCategory(id, category);
            if (updatedCategory != null) {
                return ResponseEntity.ok(updatedCategory);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @DeleteMapping("/{id}/deleteCategory")
        public ResponseEntity<Category> deleteCategory(@PathVariable String id) {
            Category deleteCategory = categoryService.deleteCategory(id);
            if (deleteCategory != null) {
                return ResponseEntity.ok(deleteCategory);
            } else {
                return ResponseEntity.notFound().build();
            }
        }



    }
