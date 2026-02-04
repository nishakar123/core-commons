package com.nishakar.commons.utils.singleton;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum JsonObjectMapperWithUtilityMethod {

    INSTANCE;

    private final ObjectMapper mapper;

    JsonObjectMapperWithUtilityMethod() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(
                com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
        );
    }

    // Utility method: Object to JSON string
    public String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Error converting object to JSON", e);
            throw new RuntimeException("JSON serialization failed", e);
        }
    }

    // Utility method: Object to pretty JSON string
    public String toPrettyJson(Object obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Error converting object to pretty JSON", e);
            throw new RuntimeException("JSON serialization failed", e);
        }
    }

    // Utility method: JSON string to Object
    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("Error parsing JSON to object", e);
            throw new RuntimeException("JSON deserialization failed", e);
        }
    }

    // Utility method: JSON string to generic type
    public <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            log.error("Error parsing JSON to object", e);
            throw new RuntimeException("JSON deserialization failed", e);
        }
    }

    // Utility method: Convert between objects
    public <T> T convertValue(Object obj, Class<T> clazz) {
        return mapper.convertValue(obj, clazz);
    }
}
