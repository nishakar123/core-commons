package com.nishakar.commons.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDTO {

    private LocalDateTime created;

    private LocalDateTime updated;

    private String createdBy;

    private String updatedBy;
}
