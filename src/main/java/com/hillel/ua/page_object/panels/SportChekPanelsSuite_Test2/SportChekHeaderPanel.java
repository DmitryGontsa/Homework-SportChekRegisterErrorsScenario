package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test2;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekHeaderPanel extends AbstractPanel {

    private static final String SIGN_IN_BUTTON = ".//a[@class='header-account__trigger']";
    private static final String SIGN_IN_POPUP_PANEL_LOCATOR = ".//section[@class='header-account__sign-in']";

    public SportChekHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickSignInButton() {
        findBy(SIGN_IN_BUTTON).waitUntilClickable().click();
    }

    public SportChekSignInPopupPanel getSportChekSignInPopupPanel() {
        return new SportChekSignInPopupPanel(findBy(SIGN_IN_POPUP_PANEL_LOCATOR), getDriverDelegate());
    }
}
