package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;



    @GetMapping("/getMerchantStock")
    public ApiResponse getMerchantStock() {
        merchantStockService.getMerchantStock();
        return (new ApiResponse(" these All merchant Stock :" + "  "
                + merchantStockService.getMerchantStock()));
    }
    @PostMapping("/merchant-stocks")
    public ResponseEntity<MerchantStock> addProductToMerchantStock(@RequestParam String productId, @RequestParam String merchantId, @RequestParam int stock) {
        merchantStockService.addProductToMerchantStock(productId, merchantId, stock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addMerchantStock")
    public MerchantStock addMerchantStock(@Valid @RequestBody MerchantStock merchantStock) {
        merchantStockService.addMerchantStock(merchantStock);
        return merchantStock;

    }

    @PutMapping("/{id}/updateMerchantStock")
    public ResponseEntity<MerchantStock> updateMerchantStock(@PathVariable String id, @Valid @RequestBody MerchantStock merchantStock) {
        MerchantStock updateMerchantStock = merchantStockService.updateMerchantStock(id, merchantStock);
        if (updateMerchantStock != null) {
            return ResponseEntity.ok(updateMerchantStock);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/deleteMerchantStock")
    public ResponseEntity<MerchantStock> deleteMerchantStock(@PathVariable String id) {
        MerchantStock deleteMerchantStock = merchantStockService.deleteMerchantStock(id);
        if (deleteMerchantStock != null) {
            return ResponseEntity.ok(deleteMerchantStock);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
