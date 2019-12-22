package FactoryObjects;


import PageObjects.HomePage;
import PageObjects.Login;
import PageObjects.SignupPage;

public class PageFactory {

    public DriverFactory driverFactory;

    public Login loginPage;
    public HomePage homePage;
    public SignupPage signupPage;

    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public Login loginPage() throws Exception {
            loginPage = new Login(driverFactory);
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
