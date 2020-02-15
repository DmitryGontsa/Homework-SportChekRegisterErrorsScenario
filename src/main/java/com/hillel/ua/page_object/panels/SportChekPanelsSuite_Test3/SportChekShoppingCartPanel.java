package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test3;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportChekShoppingCartPanel extends AbstractPanel {

    private static final String SHOPPING_CART_VALUE = ".//div[@class='header-cart__empty-message']";

    public SportChekShoppingCartPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public String getShoppingCartText() {
        return findBy(SHOPPING_CART_VALUE).getText();
    }
}
