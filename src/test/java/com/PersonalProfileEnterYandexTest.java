package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class PersonalProfileEnterYandexTest {

    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();


    @Before
    public void setUp() {
        responseData = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @DisplayName("Вход в аккаунт пользователя")
    @Test
    public void enterIntoUserAccountPositiveTest() {

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        boolean isProfileLinkDisplayed = personalAccountPage.isProfileButtonDisplayed();
        personalAccountPage.clickExitButton();

        assertTrue("User did not enter his/her personal account", isProfileLinkDisplayed);
    }

}

