package com.pragma.users.domain.constant;

public class UserConstant {

    private UserConstant() {}
    public static final String REGEX_PHONE = "^\\\\+?[0-9]{1,13}$";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*\\\\.[a-zA-Z]{2,7}$";
    public static final int MIN_AGE_USER = 18;
    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 30;
    public static final int MIN_SURNAME_LENGTH =3;
    public static final int MAX_SURNAME_LENGTH =30;

}
