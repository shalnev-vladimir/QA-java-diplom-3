package com;

import com.codeborne.selenide.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
import com.codeborne.selenide.Selenide;
import org.junit.Before;

public class CreateUserTest {

    public static final String EMAIL_POSTFIX = "@yandex.ru";

    public static final String signUpURL = "https://stellarburgers.nomoreparties.site/register";
    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
    String password = "alien6";
    String shortPassword = "12345";
    String sevenSymbolsPassword = "1234567";
    String expectedInvalidPassErrorMessage = "Некорректный пароль";


    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }


    @DisplayName("Проверяем, что можно зарегистрироваться с паролем из 6 символов")
    @Test
    public void signUpWithSixCharacterPasswordPositiveTest() {
        String expectedEnterTitle = "Вход";

        RegisterPage registerPage = Selenide.open(signUpURL, RegisterPage.class);
        registerPage.signUp(name, email, password);

        LoginPage loginPage = Selenide.page(LoginPage.class);
        String actualEnterTitle = loginPage.EnterTitle();

        assertEquals("Expected title is " + expectedEnterTitle + ". But actual is " + actualEnterTitle,
                expectedEnterTitle, actualEnterTitle);
    }

    @DisplayName("Проверяем, что можно зарегистрироваться с паролем из 7 символов")
    @Test
    public void signUpWithSevenSymbolsPassPositiveTest() {
        String expectedEnterTitle = "Вход";

        RegisterPage registerPage = Selenide.open(signUpURL, RegisterPage.class);
        registerPage.signUp(name, email, sevenSymbolsPassword);

        LoginPage loginPage = Selenide.page(LoginPage.class);
        String actualEnterTitle = loginPage.EnterTitle();

        assertEquals("Expected title is " + expectedEnterTitle + ". But actual is " + actualEnterTitle,
                expectedEnterTitle, actualEnterTitle);
    }

    @DisplayName("Проверяет, что нельзя зарегистрироваться с паролем из 5 символов")
    @Test
    public void signUpWithFiveCharacterPassNegativeTest() {

        RegisterPage registerPage = Selenide.open(signUpURL, RegisterPage.class);

        registerPage.signUp(name, email, shortPassword);
        String actualErrorMessage = registerPage.getTooShortPasswordErrorMessage();

        assertEquals("Expected error message is " + expectedInvalidPassErrorMessage + ". But actual is " + actualErrorMessage,
                expectedInvalidPassErrorMessage, actualErrorMessage);
    }

}
