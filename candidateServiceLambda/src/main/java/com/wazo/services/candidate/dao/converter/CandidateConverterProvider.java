package com.wazo.services.candidate.dao.converter;

import com.wazo.services.candidate.dao.entity.CandidateEntity;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverterProvider;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.utils.ImmutableMap;

import java.util.Map;

public final class CandidateConverterProvider implements AttributeConverterProvider {
    private final Map<EnhancedType<?>, AttributeConverter<?>> converterCache = ImmutableMap.of(
            EnhancedType.of(CandidateEntity.class), new CandidateConverter());

    public static CandidateConverterProvider create() {
        return new CandidateConverterProvider();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> AttributeConverter<T> converterFor(EnhancedType<T> enhancedType) {
        return (AttributeConverter<T>) converterCache.get(enhancedType);
    }
}
