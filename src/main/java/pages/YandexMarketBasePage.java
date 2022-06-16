package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public abstract class YandexMarketBasePage extends BasePage {

    /**
     * Переход по категории category и подкатегории subcategory
     *
     * @param category    - категория по которой хитм перейти
     * @param subcategory - подкатегория по которой хотим перейти
     * @return PageObject YandexMarketSearchPage
     */
    @Step("Переход по категории {category} и подкатегории {subcategory}")
    public YandexMarketSearchPage goByCategoryAndSubcategory(String category, String subcategory) {
        String categoryXpath = "//div[@id='catalogPopup']//li[contains(.,'" + category + "')]";
        String subcategoryXpath = "//div[@id='catalogPopup']//li[contains(.,'" + subcategory + "')]";

        $(By.id("catalogPopupButton")).should(Condition.visible).click();
        $x(categoryXpath).should(Condition.visible);
        actions().moveToElement($x(categoryXpath)).perform();
        $x(subcategoryXpath).should(Condition.visible).click();

        return page(YandexMarketSearchPage.class);
    }

}
