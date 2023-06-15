package interfaces.pageUI_wordpress_user;

public class UserHomepageUI {
    public static String USER_POST_TITLE ="xpath=//article//h2//a[text()='%s']";
    public static String USER_POST_CURRENT_DATE_BY_POST_TITLE ="xpath=//article//h2//a[text()='%s']//parent::h2//following-sibling::div//time[text()='%s']";
    public static String USER_POST_BODY = "xpath=//article//h2//a[text()='%s']//ancestor::header//following-sibling::div/p[text()='%s']";
    public static String USER_POST_AUTHOR ="xpath=//article//h2//a[text()='%s']//parent::h2//following-sibling::div//a[text()='%s']";
    public static String USER_SEARCH_POST ="xpath=//div[contains(@class,'wp-block-search')]//input[@type='search']";
    public static String USER_SEARCH_BUTTON ="xpath=//div[contains(@class,'wp-block-search')]//button[@type='submit']";

}
