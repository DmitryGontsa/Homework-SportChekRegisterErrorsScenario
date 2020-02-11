package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test2;

import com.hillel.ua.page_object.model.SportChekRegisterErrorsModel;
import com.hillel.ua.page_object.model.SportChekUserRegistrationModel;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test2.SportChekMainPage;
import com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test2.SportChekRegisterPopupPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekRegisterPopupPanelSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekRegisterPopupPanelSteps(final Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public void typeUsersData(SportChekUserRegistrationModel userRegistrationModel) {
        final SportChekRegisterPopupPanel sportChekRegisterPopupPanel = sportChekMainPage
                .getHeaderPanel().getSportChekSignInPopupPanel().getSportChekRegisterPopupPanel();
        sportChekRegisterPopupPanel.typeEmail(userRegistrationModel.getEmail());
        sportChekRegisterPopupPanel.typeConfirmEmail(userRegistrationModel.getConfirmEmail());
        sportChekRegisterPopupPanel.typePassword(userRegistrationModel.getPassword());
        sportChekRegisterPopupPanel.typeConfirmPassword(userRegistrationModel.getConfirmPassword());
        sportChekRegisterPopupPanel.clickRegisterButton();
    }

    @Step
    public SportChekRegisterErrorsModel getRegisterErrorsDisplayed() {
        return sportChekMainPage.getHeaderPanel().getSportChekSignInPopupPanel()
                .getSportChekRegisterPopupPanel().getRegisterErrors();
    }
}
