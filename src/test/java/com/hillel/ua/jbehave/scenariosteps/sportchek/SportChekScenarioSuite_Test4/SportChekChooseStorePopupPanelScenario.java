package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test4;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test4.SportChekChooseStorePopupPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test4.SportChekHeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test4.SportChekMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportChekChooseStorePopupPanelScenario {

    @Steps
    private SportChekMainPageSteps sportChekMainPageSteps;

    @Steps
    private SportChekHeaderPanelSteps sportChekHeaderPanelSteps;

    @Steps
    private SportChekChooseStorePopupPanelSteps sportChekChooseStorePopupPanelSteps;

    @Given("user is opened web site, using following url: '$url'")
    public void openSite(final String url) {
        sportChekMainPageSteps.openPage(url);
    }

    @When("user clicks 'Your Store: Choose now' button")
    public void clickChooseStoreButton() {
        sportChekHeaderPanelSteps.clickChooseStoreButton();
    }

    @When("user type next store name in search input: '$title'")
    public void typeStoreName(final String title) {
        sportChekChooseStorePopupPanelSteps.typeStoreTitle(title);
    }

    @When("user clicks on search button")
    public void clickSearchStoreButton() {
        sportChekChooseStorePopupPanelSteps.clickSearchStoreButton();
    }

    @Then("user checks following error message displayed: '$ErrorMessage'")
    public void verifySportChekFindStoreErrorMessage(final String errorMessage) {
        final String expectedErrorMessage = errorMessage;
        final String actualErrorMessage = sportChekChooseStorePopupPanelSteps.getErrorMessage();
        ReflectionAssert.assertReflectionEquals("This is incorrect error message displayed!",
                expectedErrorMessage, actualErrorMessage);
    }
}
