package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2;

import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test2.SportChekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekSignInPopupPanelSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekSignInPopupPanelSteps(final Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public void clickRegisterNowButton() {
        sportChekMainPage.getHeaderPanel().getSportChekSignInPopupPanel().clickRegisterNowButton();
    }
}
