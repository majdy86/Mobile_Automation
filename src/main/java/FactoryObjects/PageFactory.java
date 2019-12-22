package FactoryObjects;


import PageObjects.Login;

public class PageFactory {

    public DriverFactory driverFactory;

    public Login loginPage;


    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public Login loginPage() throws Exception {
            loginPage = new Login(driverFactory);
            return loginPage;
    }






}
