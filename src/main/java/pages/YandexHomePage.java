package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class YandexHomePage extends BasePage {

    /**
     * Переход на страницу яндекс маркета
     *
     * @return PageObject YandexMarketHomePage
     */
    @Step("Переход на Yandex Market")
    public YandexMarketHomePage goToYandexMarket() {
        $x("//*[contains(@data-id, 'market')]").click();
        switchTo().window(0).close();
        switchTo().window(0);
        return page(YandexMarketHomePage.class);
    }
}
