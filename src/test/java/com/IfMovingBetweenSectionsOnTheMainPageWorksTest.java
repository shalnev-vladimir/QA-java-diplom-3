package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class IfMovingBetweenSectionsOnTheMainPageWorksTest {

    @Before
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    @DisplayName("Успешный переход к блоку начинки")
    @Test
    public void ifToppingTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();

        boolean ifTitleVisible = mainPage.ifToppingsTitleVisible();

        assertTrue("Заголовок 'Начинки' не отображается", ifTitleVisible);
    }

    @DisplayName("Успешный переход к блоку соусы")
    @Test
    public void ifSauceTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();

        boolean ifTitleVisible = mainPage.ifSauceTitleVisible();

        assertTrue("Заголовок 'Соусы' не отображается", ifTitleVisible);
    }

    @DisplayName("Успешный переход к блоку булки")
    @Test
    public void ifBunsTabWorks() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        boolean ifTitleVisible = mainPage.ifBunsTitleVisible();

        assertTrue("Заголовок 'Булки' не отображается", ifTitleVisible);
    }

}
