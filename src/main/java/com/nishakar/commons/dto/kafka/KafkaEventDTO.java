package com.nishakar.commons.dto.kafka;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaEventDTO {
    @JsonAlias("fname")
    private String fName;
    @JsonAlias("lname")
    private String lName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String status;
}
