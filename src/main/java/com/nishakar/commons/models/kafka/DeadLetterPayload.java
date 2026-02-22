package com.nishakar.commons.models.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeadLetterPayload {

    // Original message fields
    private String originalTopic;
    private int originalPartition;
    private long originalOffset;
    private String originalKey;
    private String originalValue;         // raw JSON string of the failed message

    // Failure metadata
    private String errorMessage;
    private String errorClass;
    private String stackTrace;
    private int retryAttempts;

    @Builder.Default
    private LocalDateTime failedAt = LocalDateTime.now();
}
