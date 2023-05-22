package interfaces.jQueryUI;

public class HomePageUI {
    public static final String PAGE_NUMBER_LINK = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
    public static final String PAGE_NUMBER_SELECTED = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String HEADER_INPUT_FIELD="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String TOTAL_PAGE_SIZE ="xpath=//li[@class='qgrd-pagination-page']";
    public static final String ROW_ELEMENT ="xpath=//tbody/tr";
    public static final String ROW_COUNTRY_DATA ="xpath=//tbody/tr/td[@data-key='country']";
    // -------------------------
    public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead/tr/th[text()='%s']/preceding-sibling::th";
    public static final String TEXTBOX_BY_COLUMN_AND_ROW = "xpath=//tbody/tr[%s]/td[%s]/input";
    public static final String DROPDOWN_BY_COLUMN_AND_ROW = "xpath=//tbody/tr[1]/td[4]/div/select";
}
