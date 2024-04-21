package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;

@Data
@DynamoDbBean
public class ProfessionalExperience {
    private String currentOrganization;
    private String currentPosition;
    private String fromDate;
    private List<PastProfessionalExperience> pastExperience;
    private List<Certificate> certificates;
}
