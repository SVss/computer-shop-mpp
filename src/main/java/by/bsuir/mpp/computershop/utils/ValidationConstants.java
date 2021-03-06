package by.bsuir.mpp.computershop.utils;

public final class ValidationConstants {
    public static final String NON_EMPTY_STRING_REGEX = "^(?!\\s*$).+";
    public static final String EMAIL_REGEX = "^(?!\\s*$).+@(?!\\s*$).+";

    public static final String CANNOT_BE_NULL_MESSAGE = "can not be empty";
    public static final String CANNOT_BE_EMPTY_MESSAGE = CANNOT_BE_NULL_MESSAGE;
    public static final String CANNOT_BE_NEGATIVE_MESSAGE = "can not be negative";

    public static final String INVALID_VALUE_MESSAGE = "have invalid value";
}
