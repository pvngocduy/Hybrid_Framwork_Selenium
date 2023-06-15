package interfaces.pageUI_wordpress_user;

public class UserPostDetailPageUI {
    public static String USER_POST_TITLE = "xpath=//article//h1[text()='%s']";
    public static String USER_POST_CURRENT_DATE_BY_POST_TITLE ="xpath=//article//h1[text()='%s']//following-sibling::div//time[text()='%s']";
    public static String USER_POST_BODY = "xpath=//article//h1[text()='%s']//ancestor::article//div//p[text()='%s']";
    public static String USER_POST_AUTHOR ="xpath=//article//div//span//a[text()='%s']";
}
