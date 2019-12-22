package FactoryObjects;


import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignupPage;

public class PageFactory {

    public DriverFactory driverFactory;

    public LoginPage loginPage;
    public HomePage homePage;
    public SignupPage signupPage;

    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public LoginPage loginPage() throws Exception {
            loginPage = new LoginPage(driverFactory);
            return loginPage;
    }

    public HomePage homePage() throws Exception {
        homePage = new HomePage(driverFactory);
        return homePage;
    }

    public SignupPage signupPage() throws Exception {
        signupPage = new SignupPage(driverFactory);
        return signupPage;
    }



}
