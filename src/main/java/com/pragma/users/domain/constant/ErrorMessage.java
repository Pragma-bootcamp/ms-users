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
    public static final String USER_DNI_NULL= "The 'dni' property is mandatory";
    public static final String USER_ROLE_NULL= "The 'role' property is mandatory";
    public static final String USER_NAME_LENGTH = "The 'name' must have between 3 and 30 characters";
    public static final String USER_SURNAME_LENGTH = "The 'surname' must have between 3 and 30 characters";
    public static final String USER_PHONE_LENGTH = "The 'phone' must have 13 characters";
    public static final String USER_PASSWORD_LENGTH = "The 'password' must have at least 8 characters";

    public static final String USER_EMAIL_NOT_VALID = "The 'email' property value is not valid";
    public static final String USER_PHONE_NOT_VALID = "The 'phone' property value must have 13 characters and starting with '+' or not";
    public static final String USER_TOO_YOUNG = "The user is under age. You must be over 18 years old";
    public static final String USER_PASSWORD_INCORRECT = "The password is incorrect";
    public static final String EMAIL_NOT_FOUND = "The email %s was not found";
    public static final String USER_BIRTHDATE_IS_FUTURE = "¿Are you of the future? You need to insert a valid birthdate";
    public static final String USER_DNI_NOT_VALID = "The DNI %s is invalid, must be only numbers";

    public static final String PAGINATION_ERROR= "The values of page and size must be a positive number";
    public static final String SORT_DIR_ERROR = "The sortBy param must be 'asc' or 'desc' only";

    public static final String ID_NEGATIVE = "The id cannot be negative";

    public static  final String ROLE_NAME_LENGTH_ERROR = "The length of 'name' must be between 3 and 15 characters";
    public static  final String ROLE_DESCRIPTION_LENGTH_ERROR = "The length of 'description' must be between 3 and 90 characters";
    public static  final String ROLE_NAME_NULL_ERROR = "The 'name' property is mandatory";
    public static  final String ROLE_DESCRIPTION_NULL_ERROR = "The 'description' property is mandatory";

    public static final String ROLE_ALREADY_EXIST = "The role '%s' already exists";
    public static final String ROLE_ID_NOT_FOUND = "The role with the id %d does not exist";
    public static final String ROLE_NAME_NOT_FOUND = "The role with the name %s does not exist";

}
