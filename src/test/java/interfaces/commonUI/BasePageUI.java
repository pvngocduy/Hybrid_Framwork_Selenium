package interfaces.commonUI;

public class BasePageUI {
    public static final String PORTAL_LINK ="https://demo.nopcommerce.com/";
    public static final String ADMIN_PORTAL_LINK = "https://admin-demo.nopcommerce.com/";
    public static final String ADDRESSES_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static final String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Change password']";
    public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
    public static final String DOWNLOAD_PRODUCT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Downloadable products']";
    public static final String PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
    public static final String ORDERS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Orders']";
    public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static final String SUBCRIPTION_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Back in stock subscriptions']";
    public static final String DYNAMIC_MYACCOUNT_PAGE ="xpath=//div[@class='block block-account-navigation']//a[text()='%s']";
    public static final String LOGOUT_AT_ADMIN_PAGE ="xpath=//a[contains(text(),'Logout')]";
    public static final String LOGOUT_AT_USER_PAGE ="xpath=//a[@class = 'ico-logout']";
    public static final String DYNAMIC_TEXTBOX_BY_ID ="xpath=//input[@id='%s']";
    public static final String DYNAMIC_LINK_BY_NAME ="xpath=//a[text()='%s']";
    public static final String DYNAMIC_BUTTON_BY_NAME ="xpath=//button[text()='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME ="xpath=//select[@name='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_NAME ="xpath=//label[text()='%s']//preceding-sibling::input";
    public static final String DYNAMIC_CHECKBOX_BY_NAME ="xpath=//label[text()='%s:']//following-sibling::input";


}
