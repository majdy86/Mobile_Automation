package FactoryObjects;


import PageObjects.LoginPage;

public class PageFactory {

    public DriverFactory driverFactory;

    public LoginPage loginPage;


    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public LoginPage loginPage() throws Exception {
            loginPage = new LoginPage(driverFactory);
            return loginPage;
    }






}
