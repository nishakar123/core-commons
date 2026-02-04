package com.nishakar.commons.enums;

public enum Designation {
    MANAGER,
    DEVELOPER,
    TESTER;
    public String getRole(String roleName) {
        return Designation.valueOf(roleName.toUpperCase()).toString();
    }

}
