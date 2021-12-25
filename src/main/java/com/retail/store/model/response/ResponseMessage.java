package com.retail.store.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseMessage implements Serializable {

    private String message;

}