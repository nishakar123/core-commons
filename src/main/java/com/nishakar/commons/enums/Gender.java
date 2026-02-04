package com.nishakar.commons.enums;

public enum Gender {
    MALE, FEMALE, OTHER;
    public static Gender getGender(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }
}
