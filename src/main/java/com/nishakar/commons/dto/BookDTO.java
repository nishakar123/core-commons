package com.nishakar.commons.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookDTO {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private String description;
    private String category;
    private Integer price;
}
