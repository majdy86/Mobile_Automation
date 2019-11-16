package PageObjects;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.util.HashMap;
import java.util.Properties;


/**
 * Created by Amal on 11/16/2019.
 */
@Getter
@Setter
public class PageFactory {

    private static PageFactory _pageFactory;
    public  DriverManager driverManager;

    //Pages
    public static Login loginPage;


    public PageFactory(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public  PageFactory instance() {
        if (_pageFactory == null) {
            _pageFactory = new PageFactory(driverManager);
        }
        return _pageFactory;
    }

    public static Login loginPage(DriverManager manager) {
            loginPage = new Login(manager);
            return loginPage;
    }






}
