package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.Then;

public class ProfileStepDefs {

    PageFactory pageFactory;
    public ProfileStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Then("the user should be redirected to projects list page")
    public void findFilterHeader() {
        pageFactory.projectsListPage().checkFilterHeader();
    }
}
