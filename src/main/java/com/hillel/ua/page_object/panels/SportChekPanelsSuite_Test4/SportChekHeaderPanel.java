package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test4;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekHeaderPanel extends AbstractPanel {

    private static final String CHOOSE_STORE_BUTTON = ".//a[@class='header-pickup-store__link-container']";
    private static final String CHOOSE_STORE_POPUP_PANEL = ".//form[@class='pickup-modal-choose']";

    public SportChekHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickChooseStoreButton() {
        findBy(CHOOSE_STORE_BUTTON).waitUntilClickable().click();
    }

    public SportChekChooseStorePopupPanel getSportChekChooseStorePopupPanel() {
        return new SportChekChooseStorePopupPanel(findBy(CHOOSE_STORE_POPUP_PANEL).waitUntilVisible(), getDriverDelegate());
    }
}
