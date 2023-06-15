package actions.pageObjects.pageObject_Wordpress_Admin.User_Object;

import actions.Utils.MySQL.MySQLConnUtils;
import actions.commons.BasePage;
import interfaces.pageUI_wordpress_admin.pageUI_user_object.AdminUserManagerUI;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminUserManagerPageObject extends BasePage {
    WebDriver driver;
    public AdminUserManagerPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToTheUserPage(){
        clickToElement(driver, AdminUserManagerUI.USER_MENU);
    }
    public int getTotalUser(){
        clickToTheUserPage();
        String str= getTextElement(driver, AdminUserManagerUI.TOTAL_USER);
        String[] parts = str.split(" ");
        int value = Integer.parseInt(parts[0]);
        return value;
    }
    public int getTotalUserInDB() throws SQLException {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM `wp_users`";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Integer> listEmp = new ArrayList<Integer>();
        while (resultSet.next()){
            int emp_int = resultSet.getInt("ID");
            listEmp.add(emp_int);
        }
        conn.close();
        return listEmp.size();
    }
}
