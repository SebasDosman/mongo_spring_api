package co.com.dosman.service.VerboHttp.utilities;

public class UserValidate {
    public static final String USER_NOT_NULL = "User can't be null";
    public final static String NAME_NOT_NULL = "User name can't be null";
    public final static String NAME_NOT_EMPTY = "User name can't be empty";
    public final static String NAME_NOT_VALID = "User name is not valid";
    public final static String NAME_REGEX = "^[\\p{L}\\s'-]+$";
    public final static String LAST_NAME_NOT_NULL = "User last name can't be null";
    public final static String LAST_NAME_NOT_EMPTY = "User last name can't be empty";
    public final static String LAST_NAME_NOT_VALID = "User last name is not valid";
    public final static String LAST_NAME_REGEX = "^[\\p{L}\\s'-]+$";
    public final static String AGE_NOT_NULL = "User age can't be null";
    public final static String AGE_NOT_EMPTY = "User age can't be empty";
    public final static String AGE_NOT_VALID = "User age is not valid";
    public final static String AGE_REGEX = "^(0?[1-9]|[1-9][0-9]|[1][0-4][0-9])$";
    public final static String EMAIL_NOT_NULL = "User email can't be null";
    public final static String EMAIL_NOT_EMPTY = "User email can't be empty";
    public final static String EMAIL_NOT_VALID = "User email is not valid";
    public final static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public final static String PASSWORD_NOT_NULL = "User password can't be null";
    public final static String PASSWORD_NOT_EMPTY = "User password can't be empty";
    public final static String PASSWORD_NOT_VALID = "User password is not valid";
    public final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
    public final static String USER_NOT_FOUND = "User not found";
    public static final String USER_ELIMINATED = "User with id %s eliminated";
}
