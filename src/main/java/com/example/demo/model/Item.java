package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
public class Item {

    @ApiModelProperty(required = true, allowableValues = "range(0, infinity]")
    public double price;
    @ApiModelProperty(required = true)
    public String description;



}
