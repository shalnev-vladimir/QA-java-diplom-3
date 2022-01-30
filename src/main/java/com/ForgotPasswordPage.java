package com;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    // button Войти
    @FindBy(how = How.CSS,using = ".Auth_link__1fOlj")
    public SelenideElement enterButton;

    // click Enter button
    public void clickForgotPassEnterButton() {
        enterButton.click();
    }
}
