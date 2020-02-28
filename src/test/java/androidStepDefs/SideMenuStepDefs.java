package androidStepDefs;

import factoryObjects.AndroidPageFactory;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class SideMenuStepDefs {

    AndroidPageFactory androidPageFactory;

    public SideMenuStepDefs(AndroidPageFactory androidPageFactory){
        this.androidPageFactory = androidPageFactory;
    }

    @And("the side menu should displays the user's display name (.*)")
    public void userFullNameDisplayed(String displayName){
        androidPageFactory.sideMenuPage().clickSideMenuButton();
        androidPageFactory.getUser().setDisplayName(androidPageFactory.sideMenuPage().getUserDisplayName());

        //its better to retrieve expected data from API or DB for more dynamic tests
        Assert.assertEquals(displayName, androidPageFactory.getUser().getDisplayName());
    }
}
