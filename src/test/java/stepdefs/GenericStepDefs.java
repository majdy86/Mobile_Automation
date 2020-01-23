package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.And;

public class GenericStepDefs {

    PageFactory pageFactory;
    public GenericStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;

    }

    @And("refresh the current page")
    public void refreshPage(){
        pageFactory.genericPage().refreshPage();
    }
}
