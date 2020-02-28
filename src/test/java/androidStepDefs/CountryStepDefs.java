package androidStepDefs;

import factoryObjects.AndroidPageFactory;
import io.cucumber.java.en.Given;

public class CountryStepDefs {

    AndroidPageFactory androidPageFactory;

    public CountryStepDefs(AndroidPageFactory androidPageFactory){
        this.androidPageFactory = androidPageFactory;
    }

    @Given("a user on country page")
    public void theUserNavigateToHomePage() {
    }

    @Given("choose Jordan as a country")
    public void clickOnJordanButton(){
        androidPageFactory.countryPage().clickOnJordanButton();
    }
}
