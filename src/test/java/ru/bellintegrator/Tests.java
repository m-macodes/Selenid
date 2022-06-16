package ru.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.YandexHomePage;

import static com.codeborne.selenide.Selenide.open;

public class Tests extends BaseTest {

    @DisplayName("Проверка товаров яндекс маркет")
    @ParameterizedTest(name = "{displayName} : {arguments}")
    @MethodSource("helpers.DataProvider#searchParam")
    public void yandexMarketTest(String category, String subcategory, String manufacturer, String product) {
        open("https://yandex.ru/", YandexHomePage.class)
                .goToYandexMarket()
                .goByCategoryAndSubcategory(category, subcategory)
                .setManufacturerFilter(manufacturer)
                .checkResultFilterAll(product);
    }
}
