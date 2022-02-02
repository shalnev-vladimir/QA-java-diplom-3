package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class ConstructorYandexTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    @DisplayName("Переход к блоку Начинки на Главной странице. Яндекс Браузер.")
    @Test
    public void checkToppingTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();

        boolean isTitleVisible = mainPage.ifToppingsTitleVisible();

        assertTrue("Заголовок 'Начинки' не отображается", isTitleVisible);
    }

    @DisplayName("Переход к блоку Соусы на Главной странице. Яндекс Браузер.")
    @Test
    public void checkSauceTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();

        boolean isTitleVisible = mainPage.ifSauceTitleVisible();

        assertTrue("Заголовок 'Соусы' не отображается", isTitleVisible);
    }

    @DisplayName("Переход к блоку Булки на Главной странице. Яндекс Браузер.")
    @Test
    public void checkBunsTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        boolean isTitleVisible = mainPage.ifBunsTitleVisible();

        assertTrue("Заголовок 'Булки' не отображается", isTitleVisible);
    }

}

