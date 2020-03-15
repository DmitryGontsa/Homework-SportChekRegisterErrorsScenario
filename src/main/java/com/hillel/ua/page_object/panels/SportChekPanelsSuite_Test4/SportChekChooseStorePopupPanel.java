package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test4;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekChooseStorePopupPanel extends AbstractPanel {

    private static final String FIND_STORE_INPUT = ".//input[@id='pickup-modal-choose__input']";
    private static final String SEARCH_STORE_BUTTON = ".//input[@class='pickup-modal-choose__submit button button_color_blue']";
    private static final String SEARCH_STORE_ERROR_MESSAGE = ".//p[@role='alert']";

    public SportChekChooseStorePopupPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeStoreTitle(final String title) {
        findBy(FIND_STORE_INPUT).waitUntilVisible().type(title);
    }

    public void clickSearchStoreButton() {
        findBy(SEARCH_STORE_BUTTON).waitUntilVisible().click();
    }

    public String getSearchStoreErrorMessageText() {
        return findBy(SEARCH_STORE_ERROR_MESSAGE).waitUntilVisible().getText();
    }
}
