package com.wazo.services.candidate.model.request;

import lombok.Data;

@Data
public class Contact {
    private String system;
    private String value;
    private Integer rank;
}
