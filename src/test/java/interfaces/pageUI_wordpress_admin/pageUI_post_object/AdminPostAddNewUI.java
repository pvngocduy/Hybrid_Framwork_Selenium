package interfaces.pageUI_wordpress_admin.pageUI_post_object;

public class AdminPostAddNewUI {
    public static String POST_MENU = "xpath=//div[text()='Posts']";
    public static String TITLE = "xpath=//h1[@aria-label='Add title']";
    public static String BODY2 = "xpath=//p[@data-title='Paragraph']";
    public static String BODY1 = "xpath=//p[@aria-label='Add default block']";
    public static String PUBLISH_BUTTON ="xpath=//button[text()='Publish']" ;
    public static String UPDATE_BUTTON ="xpath=//button[text()='Update']";
    public static String MESSAGE_SUCCESS ="xpath=//div[@class='components-snackbar__content' and text() = '%s']";
}
