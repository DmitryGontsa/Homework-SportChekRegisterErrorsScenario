package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test1;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test1.SportChekHeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test1.SportChekMainPageSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test1.SportChekPredictiveSearchPanelSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SportChekPredictiveSearchScenario {

    @Steps
    private SportChekMainPageSteps sportChekMainPageSteps;

    @Steps
    private SportChekHeaderPanelSteps sportChekHeaderPanelSteps;

    @Steps
    private SportChekPredictiveSearchPanelSteps sportChekPredictiveSearchPanelSteps;

    @Given("user is opened site, using following url: '$url'")
    public void openSite(final String url) {
        sportChekMainPageSteps.openSite(url);
    }

    @When("user type product name in search field: '$title'")
    public void typeProductTitle(final String title) {
        sportChekHeaderPanelSteps.typePredictiveSearchText(title);
    }

    @Then("user checks predictive search, with following menu items are displayed: $table")
    public void verifyPredictiveSearchMenuItems(ExamplesTable table) {
        List expectedMenuItems = new ArrayList();
        for (Map<String, String> row : table.getRows()) {
            String menuItems = row.get("menuItems");
            expectedMenuItems.add(menuItems);
        }
        final List<String> actualMenuItems = sportChekPredictiveSearchPanelSteps.getPredictiveSearchMenuItems();

        ReflectionAssert.assertReflectionEquals("There are incorrect predictive search menu items displayed!",
                expectedMenuItems, actualMenuItems);
    }
}
