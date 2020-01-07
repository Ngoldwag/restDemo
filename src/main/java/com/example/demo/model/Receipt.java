package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
public class Receipt {
    @ApiModelProperty(required = true)
    private String store;
    private String storeSlogan;
    @ApiModelProperty(required = true)
    private int storeNumber;
    private String storeAddress;
    @ApiModelProperty(required = true, allowableValues = "range(0, infinity]")
    private double totalPrice;
    @ApiModelProperty(required = true, allowableValues = "range(0, infinity]")
    private int totalItems;
    @ApiModelProperty(dataType = " ")
    private List<Item> itemList = new ArrayList<>();

    public void setStore(String store) {
        this.store = store;
    }

    public void setNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public void add(Item itemToScan) throws IllegalAccessException {
        itemList.add(itemToScan);
        totalPrice += itemToScan.price;
        totalItems += 1;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public int getTotalItems() {
        return this.totalItems;

    }
}
