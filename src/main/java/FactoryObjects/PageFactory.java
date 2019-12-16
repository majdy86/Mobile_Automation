package FactoryObjects;


import PageObjects.Login;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by Amal on 11/16/2019.
 */
@Getter
@Setter
public class PageFactory {

    private static PageFactory _pageFactory;
    public DriverFactory driverFactory;

    //Pages
    public static Login loginPage;


    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    public  PageFactory instance() {
        if (_pageFactory == null) {
            _pageFactory = new PageFactory(driverFactory);
        }
        return _pageFactory;
    }

    public Login loginPage() {
            loginPage = new Login(driverFactory);
            return loginPage;
    }






}
