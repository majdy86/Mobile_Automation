package FactoryObjects;


import PageObjects.LoginPage;
import PageObjects.ProjectsListPage;

public class PageFactory {

    public DriverFactory driverFactory;

    private LoginPage loginPage;
    private ProjectsListPage projectsListPage;


    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public LoginPage loginPage() throws Exception {
            loginPage = new LoginPage(driverFactory);
            return loginPage;
    }

    public ProjectsListPage projectsListPage() throws Exception{
        projectsListPage = new ProjectsListPage(driverFactory);
        return projectsListPage;
    }






}
