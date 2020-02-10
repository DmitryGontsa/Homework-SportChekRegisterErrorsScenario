package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test1;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class PredictiveSearchPanel extends AbstractPanel {

    private static final String PREDICTIVE_SEARCH_ITEMS = ".//div[@class='autocomplete-suggestions chek ']//div[not (@class='autocomplete-suggestion-title') and not (@data-cat)]";

    public PredictiveSearchPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getPredictiveSearchItems() {
        return findAll(PREDICTIVE_SEARCH_ITEMS)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
