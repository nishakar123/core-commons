package com.nishakar.commons.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserInfoDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;
}
