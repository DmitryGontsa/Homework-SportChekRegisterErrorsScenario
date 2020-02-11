package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test2;

import com.hillel.ua.page_object.model.SportChekRegisterErrorsModel;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekRegisterPopupPanel extends AbstractPanel {

    private static final String EMAIL_INPUT = ".//input[@name='login']";
    private static final String CONFIRM_EMAIL_INPUT = ".//input[@name='loginConfirmation']";
    private static final String PASSWORD_INPUT = ".//input[@name='password']";
    private static final String CONFIRM_PASSWORD_INPUT = ".//input[@name='confirmPassword']";

    private static final String EMAIL_ERROR = ".//span[@for='login']";
    private static final String CONFIRM_EMAIL_ERROR = ".//span[@for='loginConfirmation']";
    private static final String PASSWORD_ERROR = ".//span[@for='password']";
    private static final String CONFIRM_PASSWORD_ERROR = ".//span[@for='confirmPassword']";

    private static final String REGISTER_BUTTON = ".//input[@value='Register']";

    public SportChekRegisterPopupPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeEmail(final String email) {
        findBy(EMAIL_INPUT).type(email);
    }

    public void typeConfirmEmail(final String confirmEmail) {
        findBy(CONFIRM_EMAIL_INPUT).type(confirmEmail);
    }

    public void typePassword(final String password) {
        findBy(PASSWORD_INPUT).type(password);
    }

    public void typeConfirmPassword(final String confirmPassword) {
        findBy(CONFIRM_PASSWORD_INPUT).type(confirmPassword);
    }

    public void clickRegisterButton() {
        findBy(REGISTER_BUTTON).waitUntilVisible().click();
    }

    public SportChekRegisterErrorsModel getRegisterErrors() {
        final String emailErrorText = findBy(EMAIL_ERROR).getText();
        final String confirmEmailErrorText = findBy(CONFIRM_EMAIL_ERROR).getText();
        final String passwordErrorText = findBy(PASSWORD_ERROR).getText();
        final String confirmPasswordErrorText = findBy(CONFIRM_PASSWORD_ERROR).getText();
        return new SportChekRegisterErrorsModel(emailErrorText, confirmEmailErrorText, passwordErrorText, confirmPasswordErrorText);
    }
}
