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
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;

public class MovingFromPersonalAccountToConstructorYandexTest {

    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";
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

    @DisplayName("Переход из Личного кабинета в Конструктор бургеров при клике на кнопку Конструктор")
    @Test
    public void moveToConstructorByClickOnConstructorButtonTest() {

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickConstructorButton();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();

        assertEquals("User not move to the main page by click 'Конструктор' button", mainPageURL, actualUrl);
    }

    @DisplayName("Переход из Личного кабинета в Конструктор бургеров при клике на логотип Stellar Burgers")
    @Test
    public void moveToConstructorByClickOnLogoTest() {

        LoginPage loginPage = Selenide.open(loginURL, LoginPage.class);
        loginPage.logIn(responseData.get("email"),responseData.get("password"));

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.clickPersonalAccountButton();

        PersonalAccountPage personalAccountPage = Selenide.page(PersonalAccountPage.class);
        personalAccountPage.clickStellarBurgerHeaderLogo();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();

        assertEquals("User not move to the main page by click 'Конструктор' button", mainPageURL, actualUrl);
    }

}
