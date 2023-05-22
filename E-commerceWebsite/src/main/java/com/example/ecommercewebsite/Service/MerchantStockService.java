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
        // retrieve the merchant stock for the product and merchant
        MerchantStock merchantStock = null;
        for (MerchantStock stockItem : merchantStocks) {
            if (stockItem.getProductId().equals(productId) && stockItem.getMerchantId().equals(merchantId)) {
                merchantStock = stockItem;
                break;
            }
        }
        // if the merchant stock doesn't exist, create a new one
        if (merchantStock == null) {
            merchantStock = new MerchantStock("1","1","1",11);
            merchantStock.setProductId(productId);
            merchantStock.setMerchantId(merchantId);
            merchantStocks.add(merchantStock);
        }
        // update the stock quantity for the merchant stock
        merchantStock.setStock(stock);

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
