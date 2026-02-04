package com.nishakar.commons.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private Integer id;

    private String name;

    private String age;

    private String gender;

    private String phone;

    private String email;

    private String address;

}
