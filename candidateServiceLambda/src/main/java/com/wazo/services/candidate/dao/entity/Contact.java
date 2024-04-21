package com.wazo.services.candidate.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String id;
    private String system;
    private String value;
    private Integer rank;
}
