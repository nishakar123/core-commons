package com.nishakar.commons.records.files;

public record FileData<T>(String fileName,
                          int totalRecords,
                          T data) {

}
