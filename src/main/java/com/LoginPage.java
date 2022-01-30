package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";

    // button Войти
    @FindBy(how = How.CSS,using = ".button_button_size_medium__3zxIa")
    public SelenideElement enterButton;

    // email input
    @FindBy(how = How.CSS,using = "fieldset:nth-child(1) input")
    public SelenideElement emailInput;

    // password input
    @FindBy(how = How.CSS,using = "fieldset:nth-child(2) input")
    public SelenideElement passInput;

    // "Восстановить пароль" button
    @FindBy(how = How.XPATH,using = "//a[@href='/forgot-password']")
    public SelenideElement recoverPassButton;

    // "Вход" title
    @FindBy(how = How.XPATH,using = "//h2[text()='Вход']")
    private SelenideElement enterTitle;

    // returns text of the title "Войти"
    public String isEnterTitleDisplayed() {
        return enterTitle.shouldBe(Condition.visible).getText();
    }

    // scroll to recover password button
    public void scrollToRecoverPassButton() {
        recoverPassButton.scrollTo();
    }

    // click recover password button
    public void clickRecoverPassButton() {
        recoverPassButton.click();
    }

    // set value in the password input to log in to an account
    public void setPassInput(String pass) {
        passInput.setValue(pass);
    }

    // set value in the email input to log in to an account
    public void setEmailInput(String email) {
        emailInput.setValue(email);
    }

    // click Войти button
    public void clickEnterButton() {
        enterButton.click();
    }

    // log in method
    public void logIn(String email, String pass) {
        setEmailInput(email);
        setPassInput(pass);
        clickEnterButton();
    }

    // public void getEnterButtonText() {
    //   enterButton.waitUntil(visible, 5000);
    // }
}
