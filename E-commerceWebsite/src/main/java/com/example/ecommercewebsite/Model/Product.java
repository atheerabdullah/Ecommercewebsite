package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {


    // I'm using multiple annotations like @Length and @max and @min @Size, and it was not working with me
    @NotNull(message = "ID must not be null")
    @Pattern(regexp = "\\d{3}", message = "ID must be 3 digits long")
    private String ID;


    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;


    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be a positive number")
    private float price;

    @NotNull(message = "Category ID must not be null")
    @Pattern(regexp = "\\d{3}", message = "Category ID must be 3 digits long")
    private String categoryID;


}
