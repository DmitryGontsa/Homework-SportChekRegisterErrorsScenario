package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test2;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekSignInPopupPanel extends AbstractPanel {

    private static final String REGISTER_NOW_BUTTON = ".//div[not (@class='header-account__sign-in__register')]//a[@class='header-account__sign-in__register__link']";
    private static final String REGISTER_POPUP_PANEL_LOCATOR = ".//section[@id='register-modal']";

    public SportChekSignInPopupPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickRegisterNowButton() {
        findBy(REGISTER_NOW_BUTTON).waitUntilClickable().click();
    }

    public SportChekRegisterPopupPanel getSportChekRegisterPopupPanel() {
        return new SportChekRegisterPopupPanel(findBy(REGISTER_POPUP_PANEL_LOCATOR), getDriverDelegate());
    }
}
