package com.example.demo.constants;

public class RegexConstants {

    public static final String VALIDATION_CONSTANT_TYPE_OF_TICKET = "^[A-Z]\\S*(?:\\s+[A-Z]\\S*)*$";
    public static final String VALIDATION_CONSTANT_TYPE_OF_FLIGHT = "^[A-Z\\d]{2}[A-Z]?\\d{1,4}[A-Z]?$";
    public static final String VALIDATION_CONSTANT_TYPE_OF_CVC = "^[0-9]{3,4}$";
    public static final String VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME = "^[A-Z]\\S*(?:\\s+[A-Z]\\S*)*$";
    public static final String VALIDATION_CONSTANT_TYPE_OF_PASSPORT_NUMBER = "[A-Z]{2}\\d{6}|^[0-9]{9}$";
    public static final String VALIDATION_CONSTANT_TYPE_OF_PHONE_NUMBER = "^\\+?3?8?(0\\d{9})$";

}
