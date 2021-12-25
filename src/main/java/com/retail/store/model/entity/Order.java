package com.retail.store.model.entity;


import com.retail.store.model.enu.PersonType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private List<Product> products;

    private double totalPrice;

    private PersonType personType;
}
