package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;

@Data
@DynamoDbBean
public class SkillSetDetails {
    private String skillType;
    private List<SkillDetail> skillDetailList;
}
