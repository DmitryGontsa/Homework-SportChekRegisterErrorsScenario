package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test2;

import com.hillel.ua.page_object.model.SportChekRegisterErrorsModel;
import com.hillel.ua.page_object.model.SportChekUserRegistrationModel;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2.SportChekHeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2.SportChekMainPageSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2.SportChekRegisterPopupPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2.SportChekSignInPopupPanelSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportChekRegisterErrorsScenario {

    @Steps
    private SportChekMainPageSteps sportChekMainPageSteps;

    @Steps
    private SportChekHeaderPanelSteps sportChekHeaderPanelSteps;

    @Steps
    private SportChekSignInPopupPanelSteps sportChekSignInPopupPanelSteps;

    @Steps
    private SportChekRegisterPopupPanelSteps sportChekRegisterPopupPanelSteps;

    @Given("user opened site, using following url: '$url'")
    public void openSite(final String url) {
        sportChekMainPageSteps.openSite(url);
    }

    @When("user clicks 'Sign In/Create Account' button")
    public void openSignInPopupPanel() {
        sportChekHeaderPanelSteps.clickSignInButton();
    }

    @When("user clicks 'Register Now' button on Sign In Popup Panel")
    public void openRegisterPopupPanel() {
        sportChekSignInPopupPanelSteps.clickRegisterNowButton();
    }

    @When("user is trying to register on Register Popup Panel, using following data: $table")
    public void typeUserData(final ExamplesTable table) {
        final SportChekUserRegistrationModel userRegistrationModel =
                table.getRowsAs(SportChekUserRegistrationModel.class).get(0);
        sportChekRegisterPopupPanelSteps.typeUsersData(userRegistrationModel);
    }

    @Then("user checks following errors messages displayed: $table")
    public void verifyRegisterPopupPanelErrorsDisplayed(ExamplesTable table) {
        final SportChekRegisterErrorsModel expectedErrors = table.getRowsAs(SportChekRegisterErrorsModel.class).get(0);
        final SportChekRegisterErrorsModel actualErrors = sportChekRegisterPopupPanelSteps.getRegisterErrorsDisplayed();
        ReflectionAssert.assertReflectionEquals("There are incorrect errors displayed!",
                expectedErrors, actualErrors);
    }
}
