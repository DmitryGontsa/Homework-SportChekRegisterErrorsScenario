package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test3;

import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test3.SportChekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekMainPageSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekMainPageSteps(final Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public void openMainPage(final String url) {
        sportChekMainPage.openUrl(url);
    }
}
