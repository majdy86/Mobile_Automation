package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.Then;

public class ProjectsListStepDefs {

    PageFactory pageFactory;

    ProjectsListStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Then("The it should redirect me to project lists")
    public void checkFilterHeader(){
        pageFactory.projectsListPage().checkFilterHeader();
    }




}
