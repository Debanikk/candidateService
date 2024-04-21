package com.wazo.services.candidate.model.request;

import lombok.Data;

@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    private String addressType;


}
