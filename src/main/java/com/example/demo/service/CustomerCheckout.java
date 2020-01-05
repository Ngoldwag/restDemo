package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;


public class CustomerCheckout {
    private Receipt receipt;

    public CustomerCheckout(String storeName, int storeNumber) {
        receipt = new Receipt();
        receipt.setNumber(storeNumber);
        receipt.setStore(storeName);

    }

    public void scanAnItem(Item itemToScan) throws IllegalAccessException {
        receipt.add(itemToScan);
    }

    public void scanAnItem(Item itemToScan, int amount) throws IllegalAccessException {
        for (int i = 0; i < amount; i++) {
            scanAnItem(itemToScan);
        }
    }

    public Receipt endTransaction() {
        return receipt;
    }
}
