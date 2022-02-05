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

    @Test
    @DisplayName("Успешный переход к блоку начинки. Яндекс браузер.")
    public void checkSwitchToToppingsSectionPositiveTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();
        boolean isFillingsTabActive = mainPage.isFillingsTabActive();
        assertTrue("Нет переключения на раздел Начинки при клике на таб Начинки", isFillingsTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки. Яндекс браузер.")
    public void checkSwitchToBunsSectionPositiveTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickBunsTab();
        boolean isBunsTabActive = mainPage.isBunsTabActive();
        assertTrue("Нет переключения на раздел Булки при клике на таб Булки", isBunsTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки. Яндекс браузер.")
    public void checkSwitchToSaucesSectionPositiveTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();
        boolean isSaucesTabActive = mainPage.isSaucesTabActive();
        assertTrue("Нет переключения на раздел Соусы при клике на таб Соусы", isSaucesTabActive);
    }

}

