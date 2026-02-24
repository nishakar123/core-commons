package com.nishakar.commons.enums;

public enum EngineType {
    PETROL,
    DIESEL,
    ELECTRIC;

    public EngineType getEngineType(String engineType) {
        return EngineType.valueOf(engineType.toUpperCase());
    }
}
