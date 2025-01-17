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

public class LogInYandexTest {

    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site";
    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String registerPageURL = "https://stellarburgers.nomoreparties.site/register";
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

    @DisplayName("Логин при клике на кнопку Войти на Главной странице в Яндекс Браузере")
    @Test
    public void logInByClickingEnterToAccountButtonTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickLogInToAccountButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();

        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

    @DisplayName("Логин при клике на кнопку Личный Аккаунт на Главной странице в Яндекс Браузере")
    @Test
    public void logInByClickingPersonalAccountButtonTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();

        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

    @DisplayName("Логин при клике на кнопку Войти на странице Регистрации (Яндекс Браузер)")
    @Test
    public void logInByClickingEnterButtonOnRegistrationPageTest() {

        RegisterPage registerPage = Selenide.open(registerPageURL, RegisterPage.class);
        registerPage.scrollToRegistrationPageEnterButton();
        registerPage.clickRegistrationPageEnterButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();

        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

    @DisplayName("Логин при клике на кнопку Войти на странице Восстановления Пароля. Яндекс Браузер")
    @Test
    public void logInByClickingEnterButtonOnForgotPasswordPageTest() {

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.scrollToRecoverPassButton();
        loginPage.clickRecoverPassButton();

        ForgotPasswordPage forgotPasswordPage = Selenide.page(ForgotPasswordPage.class);
        forgotPasswordPage.clickEnterButtonOnForgotPassPage();

        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();

        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

}


