package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test1;

import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test1.SportChekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekHeaderPanelSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekHeaderPanelSteps(Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public void typePredictiveSearchText(final String text) {
        sportChekMainPage.getHeaderPanel().typeSearchInputText(text);
    }
}
