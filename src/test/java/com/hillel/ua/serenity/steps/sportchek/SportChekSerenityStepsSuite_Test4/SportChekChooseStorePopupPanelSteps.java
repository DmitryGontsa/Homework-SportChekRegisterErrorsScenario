package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test4;

import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test4.SportChekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekChooseStorePopupPanelSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekChooseStorePopupPanelSteps(final Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public void typeStoreTitle(final String title) {
        sportChekMainPage.getHeaderPanel().getSportChekChooseStorePopupPanel().typeStoreTitle(title);
    }

    @Step
    public void clickSearchStoreButton() {
        sportChekMainPage.getHeaderPanel().getSportChekChooseStorePopupPanel().clickSearchStoreButton();
    }

    @Step
    public String getErrorMessage() {
        return sportChekMainPage.getHeaderPanel().getSportChekChooseStorePopupPanel().getSearchStoreErrorMessageText();
    }
}
