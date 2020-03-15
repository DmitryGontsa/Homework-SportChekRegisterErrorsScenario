package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test5;

import com.hillel.ua.common.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@PartialUrl(value = "categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=22")
public class SportChekProductsPage extends AbstractPage {

    private static final String SORT_BY_BUTTON = "//select[@data-module-type='FormDropdown']";
    private static final String RATING_ITEM = "//select[@data-module-type='FormDropdown']/option[text()='Rating High to Low']";
    private static final String PRODUCTS_ITEMS_SORTED_BY_RATING = "//span[@class='rating__value']";

    public SportChekProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSortByButton() {
        findBy(SORT_BY_BUTTON).click();
    }

    public void clickRatingItem() {
        findBy(RATING_ITEM).waitUntilVisible().click();
    }

    // First variant with .stream api
    public List<String> getProductItemText() {
        return findAll(PRODUCTS_ITEMS_SORTED_BY_RATING)
                .stream()
                .map(item -> {
                    String value1 = item.getAttribute("style");
                    String value2 = value1.replaceAll("\\D", "");
                    return value2;
                })
                .collect(Collectors.toList());
    }

    // Next variant with cycle for
    public List<String> getProductsItemsSortedByRatingText() {
        List<WebElementFacade> productsItemsSortedByRating = findAll(PRODUCTS_ITEMS_SORTED_BY_RATING);
        List<String> sortedByRatingText = new ArrayList<>();
        for (WebElementFacade item : productsItemsSortedByRating) {
            String value1 = item.getAttribute("style");
            String value2 = value1.replaceAll("\\D", "");
            sortedByRatingText.add(value2);
        }
        return sortedByRatingText;
    }
}
