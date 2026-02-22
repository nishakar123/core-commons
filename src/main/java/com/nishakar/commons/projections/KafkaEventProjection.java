package com.nishakar.commons.projections;

import java.time.LocalDate;

public interface KafkaEventProjection {
    String getFName();
    String getLName();
    LocalDate getDate();
    String getStatus();
}
