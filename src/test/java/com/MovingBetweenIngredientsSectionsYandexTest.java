package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class MovingBetweenIngredientsSectionsYandexTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        Configuration.browserSize = "1920x1080";
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    @DisplayName("Переход к блоку Начинки на Главной странице. Яндекс Браузер.")
    @Test
    public void ifToppingTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();

        boolean ifTitleVisible = mainPage.ifToppingsTitleVisible();

        assertTrue("Заголовок 'Начинки' не отображается", ifTitleVisible);
    }

    @DisplayName("Переход к блоку Соусы на Главной странице. Яндекс Браузер.")
    @Test
    public void ifSauceTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();

        boolean ifTitleVisible = mainPage.ifSauceTitleVisible();

        assertTrue("Заголовок 'Соусы' не отображается", ifTitleVisible);
    }

    @DisplayName("Переход к блоку Булки на Главной странице. Яндекс Браузер.")
    @Test
    public void ifBunsTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        boolean ifTitleVisible = mainPage.ifBunsTitleVisible();

        assertTrue("Заголовок 'Булки' не отображается", ifTitleVisible);
    }
}

