package com.example.ecommercewebsite.Controller;


import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProduct")
    public ApiResponse getProducts() {
        productService.getProducts();
        return (new ApiResponse("All products in the stock :" + "  "
                + productService.getProducts()));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @PutMapping("/{id}/updateProduct")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @Valid @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/deleteProduct")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        Product deletedProduct = productService.deleteProduct(id);
        if (deletedProduct != null) {
            return ResponseEntity.ok(deletedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
