package com.pragma.users.domain.constant;

public class ErrorMessage {
    private ErrorMessage() {}
    public static final String USER_ALREADY_EXISTS = "The User with the email '%s' already exists";
    public static final String USER_NAME_NULL = "The 'name' property is mandatory";
    public static final String USER_SURNAME_NULL = "The 'surname' property is mandatory";
    public static final String USER_EMAIL_NULL = "The 'email' property is mandatory";
    public static final String USER_PHONE_NULL = "The 'phone' property is mandatory";
    public static final String USER_BIRTHDATE_NULL = "The 'birthdate' property is mandatory";
    public static final String USER_PASSWORD_NULL = "The 'password' property is mandatory";

    public static final String USER_NAME_LENGTH = "The 'name' must have between 3 and 30 characters";
    public static final String USER_SURNAME_LENGTH = "The 'surname' must have between 3 and 30 characters";
    public static final String USER_PHONE_LENGTH = "The 'phone'  must have 13 characters";
    public static final String USER_PASSWORD_LENGTH = "The 'password' must have at least 8 characters";

    public static final String USER_EMAIL_NOT_VALID = "The 'email' property value is not valid";
    public static final String USER_PHONE_NOT_VALID = "The 'phone' property value must have 13 characters and starting with '+' or not";
    public static final String USER_TOO_YOUNG = "The user is under age. You must be over 18 years old";
    public static final String USER_PASSWORD_INCORRECT = "The password is incorrect";
    public static final String EMAIL_NOT_FOUND = "The email %s was not found";

    public static final String USER_BIRTHDATE_IS_FUTURE = "¿Are you of the future? You need to insert a valid birthdate";
}
