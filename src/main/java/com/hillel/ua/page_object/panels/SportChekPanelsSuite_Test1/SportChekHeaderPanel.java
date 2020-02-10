package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test1;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekHeaderPanel extends AbstractPanel {

    private static final String SEARCH_INPUT = "//input[@class='header-search__input']";
    private static final String PREDICTIVE_SEARCH_PANEL = ".//div[@class='autocomplete-suggestions-container chek']";

    public SportChekHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeSearchInputText(final String text) {
        findBy(SEARCH_INPUT).type(text);
    }

    public PredictiveSearchPanel getPredictiveSearchPanel() {
        return new PredictiveSearchPanel(findBy(PREDICTIVE_SEARCH_PANEL), getDriverDelegate());
    }
}
