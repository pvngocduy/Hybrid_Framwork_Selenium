package interfaces.pageUI_wordpress_admin.pageUI_post_object;

public class AdminPostSearchUI {
    public static String ADD_NEW ="xpath=//h1[@class ='wp-heading-inline']/following-sibling::a";
    public static String SEARCH_POST_INPUT ="xpath=//input[@type='search']";
    public static String SEARCH_POST_BUTTON ="xpath=//input[@id='search-submit']";
    public static String TABLE_HEADER_INDEX_BY_NAME = "xpath=//table[contains(@class,'table-view-list posts')]//thead//th[@id='%s']/preceding-sibling::*";
    public static String TABLE_ROW_VALUE_BY_HEADER_INDEX ="xpath=//table[contains(@class,'table-view-list posts')]//tbody//tr/*[%s]//a[text()='%s']";
    public static String EDIT_POST= "xpath=//table[contains(@class,'table-view-list posts')]//tbody//tr//*[2]//a[text()='Edit']";
    public static String DELETE_POST ="xpath=//table[contains(@class,'table-view-list posts')]//tbody//tr//*[2]//a[text()='Trash']";
    public static String MOVE_TO_TRASH_SUCCESS_MESSAGE ="xpath=//div[@id='message']//p[text()='1 post moved to the Trash. ']";
    public static String TEXT_SEARCH_NOT_FOUND ="xpath=//td[text()='No posts found.']";
}
