package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.Then;

public class ProjectListStepDefs {

    PageFactory pageFactory;

    ProjectListStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Then("The it should redirect me to project lists")
    public void displayProjectsList(){
        pageFactory.projectsListPage.displayProjectsList();
    }




}
