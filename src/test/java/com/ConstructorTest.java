package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    @DisplayName("Успешный переход к блоку начинки")
    @Test
    public void checkToppingTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();

        boolean isTitleVisible = mainPage.ifToppingsTitleVisible();

        assertTrue("Заголовок 'Начинки' не отображается", isTitleVisible);
    }

    @DisplayName("Успешный переход к блоку соусы")
    @Test
    public void checkSauceTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();

        boolean isTitleVisible = mainPage.ifSauceTitleVisible();

        assertTrue("Заголовок 'Соусы' не отображается", isTitleVisible);
    }

    @DisplayName("Успешный переход к блоку булки")
    @Test
    public void checkBunsTitleIsDisplayedTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        boolean isTitleVisible = mainPage.ifBunsTitleVisible();

        assertTrue("Заголовок 'Булки' не отображается", isTitleVisible);
    }

}
