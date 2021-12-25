package com.retail.store.model.dto;

import com.retail.store.model.enu.PersonType;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {


    private String firstName;

    private String lastName;

    private PersonType personType;

}
