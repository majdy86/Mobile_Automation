package FactoryObjects;


import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignupPage;

public class PageFactory {

    public DriverFactory driverFactory;

    public LoginPage loginPage;
    private HomePage homePage;
    private SignupPage signupPage;

    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public LoginPage loginPage() {
        loginPage = new LoginPage(driverFactory);
        return loginPage;
    }

    public HomePage homePage() {
        homePage = new HomePage(driverFactory);
        return homePage;
    }

    public SignupPage signupPage() {
        signupPage = new SignupPage(driverFactory);
        return signupPage;
    }


}
