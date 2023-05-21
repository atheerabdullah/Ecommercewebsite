package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {


//    @NotNull(message = "ID must not be null")
//    @Pattern(regexp = "\\d{3}", message = "id Merchant Stock must be 3 digits long")
    private String idMerchantStock;

//    @NotNull
//    @Min(value = 0, message = "product Id in Merchant Stock must be a positive number")
//    @Max(value = 999, message = "product Id in Merchant Stock must be 3 digits long")
    private String productId;

//    @NotNull
//    @Size(min = 3, max = 3, message = "merchant Id must be 3 characters long")
    private String merchantId;

//    @NotNull
//    @Size(min = 10, max = 10, message = "the stock should include 10 products")
    private int stock;
}