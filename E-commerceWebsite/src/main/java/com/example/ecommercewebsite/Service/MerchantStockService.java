package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    private final ProductService productService;
    private final MerchantService merchantService;


    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocks;
    }


    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }
    public void addProductToMerchantStock(String productId, String merchantId, int stock) {

        // check if the product and merchant IDs are valid
        Product product = productService.getProductById(productId);
        Merchant merchant = merchantService.getMerchantById(merchantId);
        if (product == null || merchant == null) {
           System.out.println("Invalid product or merchant ID");
        }

        // add the product to the merchant stock with the given stock quantity
        MerchantStock merchantStock = new MerchantStock("78","9","99",9);
        merchantStock.setProductId(productId);
        merchantStock.setMerchantId(merchantId);
        merchantStock.setStock(stock);
        merchantStocks.add(merchantStock);
    }

    public MerchantStock updateMerchantStock(String id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getIdMerchantStock().equals(id)) {
                merchantStocks.set(i, merchantStock);
                System.out.println("Merchant stock updated: " + merchantStock);
                return merchantStock;
            }
        }
        System.out.println("Merchant stock not found with ID: " + id);
        return null;
    }

    public MerchantStock deleteMerchantStock(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getIdMerchantStock().equals(id)){
                MerchantStock deletedMerchantStock = merchantStocks.remove(i);
                System.out.println(" Merchant Stock removed with ID: " + id);
                return deletedMerchantStock;
            }
        }
        System.out.println("Merchant Stock not found with ID: " + id);
        return null;
    }

}
