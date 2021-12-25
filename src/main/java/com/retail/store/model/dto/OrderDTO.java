package com.retail.store.model.dto;

import com.retail.store.model.enu.PersonType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

    private List<ProductDTO> products;

    private double totalPrice;

    private PersonType personType;

}
