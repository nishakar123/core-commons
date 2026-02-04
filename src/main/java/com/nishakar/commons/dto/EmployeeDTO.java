package com.nishakar.commons.dto;

import com.nishakar.commons.enums.Department;
import com.nishakar.commons.enums.Designation;
import com.nishakar.commons.enums.Gender;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO extends BaseEntityDTO implements Serializable {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    private LocalDate dateOfBirth;

    private Gender gender;

    private Department department;

    private Designation designation;

    private Double salary;

    private Boolean isActive;

    private Contact contact;

    private Address address;


    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Contact extends BaseEntityDTO implements Serializable {

        private Integer id;

        private Set<Long> phones;

        private String email;

        private String fax;

        private String website;

        private Map<String, String> socialMediaProfiles;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Address extends BaseEntityDTO implements Serializable  {

        private Integer id;

        private String street;

        private String landmark;

        private String city;

        private String district;

        private String state;

        private String country;

        private Integer postalCode;
    }
}
