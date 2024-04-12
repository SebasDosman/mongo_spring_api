package co.com.dosman.service.VerboHttp.utilities;


public class UserValidate {
    public final static String USER_NOT_NULL = "User can't be null";
    public final static String ID_NOT_NULL = "User id can't be null";
    public final static String ID_NOT_EMPTY = "User id can't be empty";
    public final static String ID_ALREADY_EXISTS = "User id already exists";
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
    public final static String AGE_TOO_YOUNG = "User age can't be less than 0";
    public final static String AGE_TOO_OLD = "User age can't be greater than 100";
    public final static String EMAIL_NOT_NULL = "User email can't be null";
    public final static String EMAIL_NOT_EMPTY = "User email can't be empty";
    public final static String EMAIL_ALREADY_EXISTS = "User email already exists";
    public final static String EMAIL_NOT_VALID = "User email is not valid";
    public final static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public final static String PASSWORD_NOT_NULL = "User password can't be null";
    public final static String PASSWORD_NOT_EMPTY = "User password can't be empty";
    public final static String PASSWORD_NOT_VALID = "User password is not valid";
    public final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
    public final static String USER_NOT_FOUND = "User not found";
    public final static String USER_ELIMINATED = "User with id %s eliminated";
}
