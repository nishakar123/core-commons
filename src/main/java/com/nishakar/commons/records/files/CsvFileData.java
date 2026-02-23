package com.nishakar.commons.records.files;

import java.util.List;
import java.util.Map;

public record CsvFileData(int totalRecords,
                          List<String> headers,
                          List<Map<String, String>> rows) {
}
