package com.wazo.services.candidate.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    private String locationId;
    private String locationName;
    private String Address;
    private String City;
    private String State;
    private String ZipCode;
    private String Country;
    private String AddressType;
}
