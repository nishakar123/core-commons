package com.nishakar.commons.records.files;

import java.util.List;
import java.util.Map;

public record JsonFileData(int totalRecords,
                           List<Map<String, Object>> records) {
}
