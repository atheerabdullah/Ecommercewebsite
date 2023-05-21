package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductService {


    ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getID().equals(id)) {
                return product;
            }
        }
        return null;
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public Product updateProduct(String id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID().equals(id)) {
                products.set(i, product);
                System.out.println("Product updated: " + product);
                return product;
            }
        }
        System.out.println("Product not found with ID: " + id);
        return null;
    }

    public Product deleteProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID().equals(id)) {
                Product deletedProduct = products.remove(i);
                System.out.println("Product removed with ID: " + id);
                return deletedProduct;
            }
        }
        System.out.println("Product not found with ID: " + id);
        return null;
    }



}
