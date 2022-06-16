package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexMarketSearchPage extends YandexMarketBasePage {

    private final String greyScreen = "//div[@data-grabber='SearchSerp']/*[@data-tid]";

    /**
     * Задаем производителя для фильтра manufacturer
     *
     * @param manufacturer - производитель
     * @return PageObject YandexMarketSearchPage
     */
    @Step("Устанавливаем производителя {manufacturer}")
    public YandexMarketSearchPage setManufacturerFilter(String manufacturer) {
        String manufacturerLabel = "//label[contains(., '" + manufacturer + "')]";
        String moreButton = "//span[contains(text(),'Показать всё')]";
        String progressbar = "//span[@role='progressbar']";

        $x(moreButton).should(visible).click();
        $x(progressbar).shouldNot(exist);
        $x(manufacturerLabel).click();
        $x(greyScreen).should(exist).shouldNot(exist);
        return this;
    }

    /**
     * Проверка, что на всех страницах резльтата поиска товары исключительно productName
     *
     * @param productName - наименование продукции
     * @return PageObject YandexMarketSearchPage
     */
    @Step("Проверяем что на всех страницах результата поиска исключительно товар {productName}")
    public YandexMarketSearchPage checkResultFilterAll(String productName) {
        String nextButton = "//span[contains(text(), 'Вперёд')]";
        
        while ($x(nextButton).exists()) {
            Assertions.assertTrue(checkResultFilter(productName));
            $x(nextButton).should(enabled).click();
            $x(greyScreen).shouldNot(exist);
        }
        Assertions.assertTrue(checkResultFilter(productName));
        return this;
    }

    /**
     * Проверяем что в рузультате поиска исключительно товар productName
     *
     * @param productName - наименование нужного товара
     * @return - true, если в реузультате исключительно товары productName. false, если иначе
     */
    private boolean checkResultFilter(String productName) {
        String endPage = "//div[contains(text(), 'Вы посмотрели')]";
        String productsNames = "//div[contains(@data-apiary-widget-id,'SearchSerp')]//article//h3";

        actions().moveToElement($x(endPage)).perform();
        return $$x(productsNames).stream().allMatch(p -> p.text().contains(productName));
    }
}
