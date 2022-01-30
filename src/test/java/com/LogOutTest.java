package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class LogOutTest {

    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();

    @Before
    public void setUp() {
        responseData = userOperations.register();
        Configuration.browserSize = "1920x1080";
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @DisplayName("Проверяет, что пользователь может разлогиниться")
    @Test
    public void logOutTest() {
        String expectedEnterTitle = "Вход";

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();

        String actualEnterTitle = loginPage.isEnterTitleDisplayed();

        assertEquals("User didn't move to the login page", expectedEnterTitle, actualEnterTitle);
    }

}
