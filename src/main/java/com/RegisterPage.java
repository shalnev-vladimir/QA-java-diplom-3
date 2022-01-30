package com;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {


    // name input
    @FindBy(how = How.CSS,using = "fieldset:nth-child(1) input")
    private SelenideElement nameInput;

    // email input
    @FindBy(how = How.CSS,using = "fieldset:nth-child(2) input")
    private SelenideElement emailInput;

    // password input
    @FindBy(how = How.XPATH,using = "//input[@type='password']")
    private SelenideElement passInput;

    // sign up button
    @FindBy(how = How.CSS,using = ".button_button__33qZ0")
    private SelenideElement signUpButton;

    // error message .input__error
    @FindBy(how = How.CSS,using = ".input__error")
    private SelenideElement tooShortPasswordErrorMessage;

    // "Войти" button
    @FindBy(how = How.CSS,using = ".Auth_link__1fOlj")
    private SelenideElement RegistrationPageEnterButton;

    // click enter button
    public void clickRegistrationPageEnterButton() {
        RegistrationPageEnterButton.click();
    }

    // scroll to enter button
    public void scrollToRegistrationPageEnterButton() {
        RegistrationPageEnterButton.scrollTo();
    }


    // enter a value in the name field
    public void setNameInput(String name) {
        nameInput.setValue(name);
    }

    // enter a value in the Email field
    public void setEmailInput(String email) {
        emailInput.setValue(email);
    }

    // enter a value in the password field
    public void setPassInput(String password) {
        passInput.setValue(password);
    }

    // clicks sign up button
    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void setTooShortPassword(String shortPassword) {
        passInput.setValue(shortPassword);
    }

    public String getTooShortPasswordErrorMessage() {
        return tooShortPasswordErrorMessage.getText();
    }

    public void signUp(String name, String email, String password) {
        setNameInput(name);
        setEmailInput(email);
        setPassInput(password);
        clickSignUpButton();
    }
}
