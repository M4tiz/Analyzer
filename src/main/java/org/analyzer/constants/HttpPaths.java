package org.analyzer.constants;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public class HttpPaths {

    public static final String LOGIN = "/login";
    public static final String LOGIN_REQUEST = "/login/request";
    public static final String LOGIN_FAILED = "/login?error";
    public static final String HTTP_ERROR = "/error";
    public static final String DASHBOARD = "/dashboard";
    public static final String LOGOUT = "/logout";

    /** User **/
    public static final String USER_BASE_PATH = "/user/";
    public static final String ADD_USER = USER_BASE_PATH + "add/{username}/{password}/{role}";

    /** Dialog **/
    public static final String DIALOG_START = "/dialog/{categoryId}/start";
    public static final String DIALOG_INPUT = "/dialog/input";

    /** Dialog Category **/
    public static final String CATEGORY_SELECT = "/category/category_select";
}
