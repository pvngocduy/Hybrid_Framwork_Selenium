package actions.commons;

import java.io.File;

public class GlobalConstant {
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String DEV_URL = "https://demo.guru99.com/";
    public static String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
    public static String ADMIN_DEV_URL ="https://admin-demo.nopcommerce.com/";

    public static String UPLOADFILE = System.getProperty("user.dir") + File.separator +"uploadFiles" + File.separator;
    public static long SHORT_TIMEOUT = 5;
    public static long LONG_TIMEOUT = 1;
    public static String REPORTNG_SCREENSHOT = System.getProperty("user.dir") + File.separator +"reportNGImages" + File.separator;
    public static String PROPERTIES_FILE_PATH =System.getProperty("user.dir") + File.separator +"src"+ File.separator +"test" + File.separator +"resources" + File.separator + "configs.properties";
    public static String PROJECT_PATH = System.getProperty("user.dir");
}
