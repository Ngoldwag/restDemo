package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CustomerCheckout;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/cashRegister/api")
public class CashRegisterController {
    private static CustomerCheckout customerCheckout;

    @GetMapping("/customerCheckout/{store}/{number}")
    public void customerCheckout(@ApiParam(required = true) @PathVariable(value = "store") String storeName, @PathVariable(value = "number") int storeNumber) {

        customerCheckout = new CustomerCheckout(storeName, storeNumber);
    }

    @PostMapping("/scanAnItem")
    public void scanAnItem(@ApiParam(required = true) @RequestBody ItemDetails itemDetails) throws IllegalAccessException {
        Item item = new Item(itemDetails.itemPrice, itemDetails.itemDescription);
        if (itemDetails.amount != 0) {
            customerCheckout.scanAnItem(item, itemDetails.amount);
        } else {
            customerCheckout.scanAnItem(item);
        }

    }

    @GetMapping("/endTransaction")
    public Receipt endTransaction() {
        return customerCheckout.endTransaction();
    }

}


