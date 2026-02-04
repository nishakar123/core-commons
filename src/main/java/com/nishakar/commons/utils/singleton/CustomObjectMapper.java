package com.nishakar.commons.utils.singleton;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum CustomObjectMapper {
    INSTANCE;

    private final ObjectMapper mapper;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    CustomObjectMapper() {
        this.mapper = new ObjectMapper();
        configure();
    }

    private void configure() {
        // Custom Java Time Module with formatters
        SimpleModule javaTimeModule = new SimpleModule();
        javaTimeModule.addSerializer(LocalDate.class,
                new LocalDateSerializer(DATE_FORMATTER));
        javaTimeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DATE_FORMATTER));
        javaTimeModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DATETIME_FORMATTER));
        javaTimeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DATETIME_FORMATTER));

        mapper.registerModule(javaTimeModule);

        // General configuration
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        // Property naming strategy (optional)
        // mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    public ObjectMapper get() {
        return mapper;
    }

    public String toJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }

    public <T> T fromJson(String json, TypeReference<T> typeRef) throws JsonProcessingException {
        return mapper.readValue(json, typeRef);
    }
}
