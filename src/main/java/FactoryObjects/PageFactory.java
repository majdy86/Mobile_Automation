package FactoryObjects;


import PageObjects.*;

public class PageFactory {

    public DriverFactory driverFactory;

    private LoginPage loginPage;
    private HomePage homePage;
    private SignupPage signupPage;
    private ProjectsListPage projectsListPage;
    private CreateProjectPage createProjectPage;
    private InvitePage invitePage;
    private ProjectDetailsPage projectDetailsPage;
    private TermBasePage termBasePage;
    private TranslationMemoryPage translationMemoryPage;
    private WorkspacePage workspacePage;
    private SettingsPage settingsPage;
    private ProfilePage profilePage;
    private SelectUserTypePage selectUserTypePage;

    public PageFactory(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }


    public LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(driverFactory);
        return loginPage;
    }

    public HomePage homePage() {
        if (homePage == null)
            homePage = new HomePage(driverFactory);
        return homePage;
    }

    public SignupPage signupPage() {
        if (signupPage == null)
            signupPage = new SignupPage(driverFactory);
        return signupPage;
    }

    public ProjectsListPage projectsListPage() {
        if (projectsListPage == null)
            projectsListPage = new ProjectsListPage(driverFactory);
        return projectsListPage;
    }

    public CreateProjectPage createProjectPage() {
        if (createProjectPage == null)
            createProjectPage = new CreateProjectPage(driverFactory);
        return createProjectPage;
    }

    public InvitePage invitePage() {
        if (invitePage == null)
            invitePage = new InvitePage(driverFactory);
        return invitePage;
    }

    public TermBasePage termBasePage() {
        if (termBasePage == null)
            termBasePage = new TermBasePage(driverFactory);
        return termBasePage;
    }

    public TranslationMemoryPage translationMemoryPage() {
        if (translationMemoryPage == null)
            translationMemoryPage = new TranslationMemoryPage(driverFactory);
        return translationMemoryPage;
    }

    public WorkspacePage workspacePage() {
        if (workspacePage == null)
            workspacePage = new WorkspacePage(driverFactory);
        return workspacePage;
    }

    public SettingsPage settingsPage() {
        if (settingsPage == null)
            settingsPage = new SettingsPage(driverFactory);
        return settingsPage;
    }

    public ProfilePage profilePage() {
        if (profilePage == null)
            profilePage = new ProfilePage(driverFactory);
        return profilePage;
    }

    public SelectUserTypePage selectUserTypePage() {
        if (selectUserTypePage == null)
            selectUserTypePage = new SelectUserTypePage(driverFactory);
        return selectUserTypePage;
    }


}
