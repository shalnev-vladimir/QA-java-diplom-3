package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    // button Выйти
    @FindBy(how = How.CSS,using = ".Account_button__14Yp3")
    public SelenideElement exitButton;

    // button Конструктор
    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    public SelenideElement constructorButton;

    // stellar burger header logo
    @FindBy(how = How.CSS,using = ".AppHeader_header__logo__2D0X2")
    public SelenideElement headerLogo;

    // button Профиль
    @FindBy(how = How.XPATH,using = "//a[text()='Профиль']")
    public SelenideElement profileButton;

    public boolean isProfileButtonDisplayed() {
        return profileButton.shouldBe(Condition.exist).isDisplayed();
    }

    // click stellar burger header logo
    public void clickStellarBurgerHeaderLogo() {
        headerLogo.click();
    }

    // click Конструктор button
    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickExitButton() {
        exitButton.click();
    }

}

