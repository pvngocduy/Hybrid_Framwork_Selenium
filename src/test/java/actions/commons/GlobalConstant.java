package actions.commons;

import java.io.File;

public class GlobalConstant {
    public static String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
    public static String ADMIN_DEV_URL ="https://admin-demo.nopcommerce.com/";

    public static String UPLOADFILE = System.getProperty("user.dir") + File.separator +"uploadFiles" + File.separator;
    public static long SHORT_TIMEOUT = 5;
    public static long LONG_TIMEOUT = 10;
}
