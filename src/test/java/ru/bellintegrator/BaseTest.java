package ru.bellintegrator;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.alure.selenide.CustomAllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void options() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
