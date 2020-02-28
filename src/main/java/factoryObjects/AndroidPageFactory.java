package factoryObjects;


import androidPageObjects.*;
import testDataProvider.User;

public class AndroidPageFactory {

    public MobileDriverFactory mobileDriverFactory;

    private CountryPage countryPage;
    private LoginPage loginPage;
    private GenericPage genericPage;
    private HomePage homePage;
    private SideMenuPage sideMenuPage;
    private User user;

    public AndroidPageFactory(MobileDriverFactory mobileDriverFactory) {
        this.mobileDriverFactory = mobileDriverFactory;
    }


    public CountryPage countryPage(){
        if(countryPage == null)
            countryPage = new CountryPage(mobileDriverFactory);
        return countryPage;
    }

    public LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(mobileDriverFactory);
        return loginPage;
    }

    public GenericPage genericPage(){
        if(genericPage == null)
            genericPage = new GenericPage(mobileDriverFactory);
        return genericPage;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(mobileDriverFactory);
        return homePage;
    }

    public SideMenuPage sideMenuPage(){
        if(sideMenuPage == null)
            sideMenuPage = new SideMenuPage(mobileDriverFactory);
        return sideMenuPage;
    }

    public User getUser(){
        if (user == null)
            user = new User();
        return user;
    }


}
