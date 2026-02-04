package com.nishakar.commons.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDTO {

    public Integer id;

    public String username;

    public String password;

    public List<String> roles;
}
