package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();


    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public Merchant getMerchantById(String id) {
        for (Merchant merchant : merchants) {
            if (merchant.getIdMerchant().equals(id)) {
                return merchant;
            }
        }
        return null;
    }

    public void addMerchant(Merchant merchant) {
        merchants.add(merchant);
    }

    public Merchant updateMerchant(String id, Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getIdMerchant().equals(id)) {
                merchants.set(i, merchant);
                System.out.println("Merchant updated: " + merchant);
                return merchant;
            }
        }
        System.out.println("Merchant not found with ID: " + id);
        return null;
    }

    public Merchant deleteMerchant(String id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getIdMerchant().equals(id)) {
                Merchant deletedMerchant = merchants.remove(i);
                System.out.println("Merchant removed with ID: " + id);
                return deletedMerchant;
            }
        }
        System.out.println("Merchant not found with ID: " + id);
        return null;
    }

}
