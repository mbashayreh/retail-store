package com.retail.store.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private String name;

    private String description;

    private double price;

    private String color;

    private String size;
}
