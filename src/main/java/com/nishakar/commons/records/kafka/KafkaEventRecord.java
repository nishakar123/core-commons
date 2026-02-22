package com.nishakar.commons.records.kafka;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record KafkaEventRecord(@JsonAlias("fname") String fName,
                               @JsonAlias("lname") String lName,
                               @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date,
                               String status) {
}
