package com.it_academy.selenium.Tests;

import com.it_academy.onliner.pageobject.OnlinerHomePage;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerAccessoriesSectionTest extends BaseTest {
    private final OnlinerHomePage ONLINER_HOME_PAGE = new OnlinerHomePage();
    private final int NUMBER_OF_ACCESSORY_OBJECTS = 14;

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjectsAndAllHaveTitles() {
        List<String> AccessoriesTitles = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles.size()).
                as("Accessory section has invalid number of products").isEqualTo(NUMBER_OF_ACCESSORY_OBJECTS);
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
    }

    @Test
    public void testAccessorySectionHasCorrectNumberOfObjects() {
        List<String> AccessoriesTitles = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductTitleFromAccessorySectionList();
        assertThat(AccessoriesTitles.stream().allMatch(Objects::nonNull))
                .as("Accessory products' titles are not displayed").isTrue();
        assertThat(AccessoriesTitles.stream().
                anyMatch(t -> t.contains("Видеокарты"))).withFailMessage("").isTrue();
    }

    @Test
    public void testAccessorySectionObjectsHaveAmountAndPrices() {
        List<String> AccessoriesSectionPriceAndNumberList = ONLINER_HOME_PAGE
                .clickOnHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры и\u00a0сети")
                .clickOnAccessoriesSectionLink("Комплектующие")
                .getProductAmountAndPriceFromAccessorySectionList();
        assertThat((AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("товар")))).
                withFailMessage("Accessory section does not have section amount of product").isTrue();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("от"))).
                withFailMessage("Accessory section does not have section price").isTrue();
        assertThat(AccessoriesSectionPriceAndNumberList.stream().
                allMatch(t -> t.contains("р."))).
                withFailMessage("Accessory section does not have section price").isTrue();
    }
}
