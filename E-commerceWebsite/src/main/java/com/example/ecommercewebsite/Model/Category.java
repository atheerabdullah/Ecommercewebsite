package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {



    @NotNull(message = "ID must not be null")
    @Pattern(regexp = "\\d{3}", message = "ID must be 3 digits long")
    private String idCategory_Category;


    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String nameCategory;
}
