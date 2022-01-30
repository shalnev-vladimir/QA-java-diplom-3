package com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class EnterIntoAUserProfileTest {

    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String expectedProfileURL = "https://stellarburgers.nomoreparties.site/account/profile";
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

    @DisplayName("Вход в аккаунт пользователя")
    @Test
    public void enterIntoAUserAccount() {

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        // сначала в адресной строке появляется /account, потом /profile
        // если не поставить ожидание, то значение url будет https://stellarburgers.nomoreparties.site/account
        sleep(2000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        personalAccountPage.clickExitButton();

        assertEquals("User did not move to the personal account by clicking 'Личный кабинет' button",
                expectedProfileURL, currentUrl);
    }

}

