package interfaces.jQueryUI;

public class HomePageUploadUI {
    public static String UPLOAD_FILE ="xpath=//input[@type='file']";
    public static String FILENAME_LOADED ="xpath=//td/p[@class='name' and text() = '%s']";
    public static String BUTTON_UPLOAD = "xpath=//td/button[@class ='btn btn-primary start']";
    public static String FILENAME_UPLOADED_LINK = "xpath=//a[text()='%s']";
    public static String FILENAME_UPLOADED_IMAGE = "xpath=//a[@title = '%s']/img";
}
