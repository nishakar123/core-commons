package com.nishakar.commons.enums;

public enum Department {
    ENGINEERING,
    SALES,
    MARKETING;
    public static Department getDepartmentByString(String departmentName) {
        return Department.valueOf(departmentName.toUpperCase());
    }

}
