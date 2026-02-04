package com.nishakar.commons.utils.singleton;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public enum ObjectMapperEnumSingleton {
    INSTANCE;

    private final ObjectMapper objectMapper;

    ObjectMapperEnumSingleton() {
        this.objectMapper = new ObjectMapper();
        configureObjectMapper();
    }

    private void configureObjectMapper() {
        // Register Java 8 Date/Time module
        objectMapper.registerModule(new JavaTimeModule());

        // Don't include null values
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Don't write dates as timestamps
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Ignore unknown properties during deserialization
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // Pretty print (optional - disable in production)
        // objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ObjectMapper getMapper() {
        return objectMapper;
    }
}
