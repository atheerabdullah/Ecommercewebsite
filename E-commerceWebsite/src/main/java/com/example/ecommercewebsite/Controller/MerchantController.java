package com.example.ecommercewebsite.Controller;


import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MerchantController {

private final MerchantService merchantService;



    @GetMapping("/getMerchants")
    public ApiResponse getMerchants() {
        merchantService.getMerchants();
        return (new ApiResponse("All Merchants in the stock :" + "  "
                + merchantService.getMerchants()));
    }

    @GetMapping("/Merchants/{id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable String id) {
        Merchant merchant = merchantService.getMerchantById(id);
        if (merchant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }

    @PostMapping("/addMerchant")
    public Merchant addMerchant(@Valid @RequestBody Merchant merchant) {
        merchantService.addMerchant(merchant);
        return merchant;

    }

    @PutMapping("/{id}/updateMerchant")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable String id, @Valid @RequestBody Merchant merchant) {
        Merchant updateMerchant = merchantService.updateMerchant(id, merchant);
        if (updateMerchant != null) {
            return ResponseEntity.ok(updateMerchant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/deleteMerchant")
    public ResponseEntity<Merchant> deleteMerchant(@PathVariable String id) {
        Merchant deleteMerchant = merchantService.deleteMerchant(id);
        if (deleteMerchant != null) {
            return ResponseEntity.ok(deleteMerchant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
