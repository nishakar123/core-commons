package com.nishakar.commons.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtils {

    // Common date formats
    public static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ISO_DATE; // yyyy-MM-dd
    public static final DateTimeFormatter ISO_DATE_TIME = DateTimeFormatter.ISO_DATE_TIME;
    public static final DateTimeFormatter BASIC_DATE = DateTimeFormatter.BASIC_ISO_DATE; // yyyyMMdd

    public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter MM_DD_YYYY = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DD_MM_YYYY_SLASH = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter MM_DD_YYYY_SLASH = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATETIME_WITH_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter DISPLAY_DATETIME = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
    public static final DateTimeFormatter DISPLAY_DATE = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static final DateTimeFormatter TIME_12HR = DateTimeFormatter.ofPattern("hh:mm:ss a");
    public static final DateTimeFormatter TIME_24HR = DateTimeFormatter.ofPattern("HH:mm:ss");

    // ============= String to LocalDate =============

    /**
     * Parse string to LocalDate with custom format
     */
    public static LocalDate parseToLocalDate(String dateStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr, e);
        }
    }

    /**
     * Parse string to LocalDate with DateTimeFormatter
     */
    public static LocalDate parseToLocalDate(String dateStr, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr, e);
        }
    }

    /**
     * Parse ISO date string (yyyy-MM-dd)
     */
    public static LocalDate parseISODate(String dateStr) {
        return parseToLocalDate(dateStr, ISO_DATE);
    }

    // ============= String to LocalDateTime =============

    /**
     * Parse string to LocalDateTime with custom format
     */
    public static LocalDateTime parseToLocalDateTime(String dateTimeStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid datetime format: " + dateTimeStr, e);
        }
    }

    /**
     * Parse string to LocalDateTime with DateTimeFormatter
     */
    public static LocalDateTime parseToLocalDateTime(String dateTimeStr, DateTimeFormatter formatter) {
        try {
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid datetime format: " + dateTimeStr, e);
        }
    }

    // ============= LocalDate to String =============

    /**
     * Format LocalDate to string with custom pattern
     */
    public static String formatLocalDate(LocalDate date, String pattern) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Format LocalDate to string with DateTimeFormatter
     */
    public static String formatLocalDate(LocalDate date, DateTimeFormatter formatter) {
        if (date == null) return null;
        return date.format(formatter);
    }

    /**
     * Format LocalDate to ISO format (yyyy-MM-dd)
     */
    public static String formatToISO(LocalDate date) {
        return formatLocalDate(date, ISO_DATE);
    }

    /**
     * Format LocalDate to dd-MM-yyyy
     */
    public static String formatToDDMMYYYY(LocalDate date) {
        return formatLocalDate(date, DD_MM_YYYY);
    }

    /**
     * Format LocalDate to MM-dd-yyyy
     */
    public static String formatToMMDDYYYY(LocalDate date) {
        return formatLocalDate(date, MM_DD_YYYY);
    }

    // ============= LocalDateTime to String =============

    /**
     * Format LocalDateTime to string with custom pattern
     */
    public static String formatLocalDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * Format LocalDateTime to string with DateTimeFormatter
     */
    public static String formatLocalDateTime(LocalDateTime dateTime, DateTimeFormatter formatter) {
        if (dateTime == null) return null;
        return dateTime.format(formatter);
    }

    /**
     * Format LocalDateTime to yyyy-MM-dd HH:mm:ss
     */
    public static String formatToDateTime(LocalDateTime dateTime) {
        return formatLocalDateTime(dateTime, DATETIME_FORMAT);
    }

    /**
     * Format LocalDateTime to display format (dd MMM yyyy HH:mm:ss)
     */
    public static String formatToDisplayDateTime(LocalDateTime dateTime) {
        return formatLocalDateTime(dateTime, DISPLAY_DATETIME);
    }

    // ============= Convert between formats =============

    /**
     * Convert date string from one format to another
     */
    public static String convertDateFormat(String dateStr, String fromFormat, String toFormat) {
        LocalDate date = parseToLocalDate(dateStr, fromFormat);
        return formatLocalDate(date, toFormat);
    }

    /**
     * Convert date string from one format to another using DateTimeFormatter
     */
    public static String convertDateFormat(String dateStr, DateTimeFormatter fromFormatter,
                                           DateTimeFormatter toFormatter) {
        LocalDate date = parseToLocalDate(dateStr, fromFormatter);
        return formatLocalDate(date, toFormatter);
    }

    /**
     * Convert datetime string from one format to another
     */
    public static String convertDateTimeFormat(String dateTimeStr, String fromFormat, String toFormat) {
        LocalDateTime dateTime = parseToLocalDateTime(dateTimeStr, fromFormat);
        return formatLocalDateTime(dateTime, toFormat);
    }

    // ============= Date conversions =============

    /**
     * Convert java.util.Date to LocalDate
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * Convert java.util.Date to LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Convert LocalDate to java.util.Date
     */
    public static Date toDate(LocalDate localDate) {
        if (localDate == null) return null;
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Convert LocalDateTime to java.util.Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // ============= Timestamp conversions =============

    /**
     * Convert epoch milliseconds to LocalDateTime
     */
    public static LocalDateTime fromEpochMilli(long epochMilli) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(epochMilli),
                ZoneId.systemDefault()
        );
    }

    /**
     * Convert LocalDateTime to epoch milliseconds
     */
    public static long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Get current timestamp in milliseconds
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    // ============= Utility methods =============

    /**
     * Get current date as LocalDate
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * Get current datetime as LocalDateTime
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Get current date formatted as string
     */
    public static String getCurrentDateAsString(String format) {
        return formatLocalDate(LocalDate.now(), format);
    }

    /**
     * Get current datetime formatted as string
     */
    public static String getCurrentDateTimeAsString(String format) {
        return formatLocalDateTime(LocalDateTime.now(), format);
    }

    /**
     * Check if date string is valid for given format
     */
    public static boolean isValidDate(String dateStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Check if datetime string is valid for given format
     */
    public static boolean isValidDateTime(String dateTimeStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDateTime.parse(dateTimeStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Add days to a date
     */
    public static LocalDate addDays(LocalDate date, long days) {
        return date.plusDays(days);
    }

    /**
     * Subtract days from a date
     */
    public static LocalDate subtractDays(LocalDate date, long days) {
        return date.minusDays(days);
    }

    /**
     * Get difference in days between two dates
     */
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Check if date is in the past
     */
    public static boolean isPast(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    /**
     * Check if date is in the future
     */
    public static boolean isFuture(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    /**
     * Check if date is today
     */
    public static boolean isToday(LocalDate date) {
        return date.equals(LocalDate.now());
    }
}
