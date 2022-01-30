package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class MainPage {

    // log in to account button
    @FindBy(how = How.CSS,using = ".button_button__33qZ0")
    private SelenideElement logInButton;

    // main page logo "Соберите бургер" //h1[text()='Соберите бургер'] .text_type_main-large
    @FindBy(how = How.XPATH,using = "//h1[text()='Соберите бургер']")
    private SelenideElement setUpBurgerTitle;

    // personal account button .AppHeader_header__link__3D_hX:nth-child(3) .AppHeader_header__linkText__3q_va
    @FindBy(how = How.CSS,using = ".AppHeader_header__link__3D_hX:nth-child(3) .AppHeader_header__linkText__3q_va")
    private SelenideElement personalAccountButton;

    // tab Булки
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(1)")
    private SelenideElement bunsTab;

    // title Булки
    @FindBy(how = How.CSS,using = ".text_type_main-medium:nth-child(1)")
    private SelenideElement bunsTitle;

    // tab Соусы
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(2)")
    private SelenideElement sauceTab;

    // title Соус
    @FindBy(how = How.CSS,using = ".text:nth-child(3)")
    private SelenideElement sauceTitle;

    // tab Начинки
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(3)")
    private SelenideElement toppingsTab;

    // title Начинки
    @FindBy(how = How.CSS,using = ".text:nth-child(5)")
    private SelenideElement toppingsTitle;

    // click buns tab
    public void clickBunsTab() {
        bunsTab.click();
    }

    public String getBunsTabCssValue() {
        return bunsTab.getCssValue("box-shadow");
    }

    // if the Булки title visible
    public boolean ifBunsTitleVisible() {
        return bunsTitle.is(Condition.visible);
    }

    // click sauce tab
    public void clickSauceTab() {
        sauceTab.click();
    }

    // if the Соусы title visible
    public boolean ifSauceTitleVisible() {
        return sauceTitle.is(Condition.visible);
    }

    public boolean isSauceTabSelected() {
        return sauceTab.isSelected();
    }

    // if the Начинки title visible
    public boolean ifToppingsTitleVisible() {
        return toppingsTitle.is(Condition.visible);
    }

    // click Начинки tab
    public void clickToppingsTab() {
        toppingsTab.click();
    }

    // get toppings tab css value
    public String getToppingsTabCssValue() {
        return toppingsTab.getCssValue("box-shadow");
    }

    // get sauce tab css value
    public String getSauceTabCssValue() {
        return sauceTab.getCssValue("box-shadow");
    }

    // click personal account button
    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(Condition.exist).click();
    }

    // scroll to "Соберите бургер" title
    public void scroolToSetUpBurgerTitle() {
        setUpBurgerTitle.scrollTo().shouldBe(Condition.visible);
    }

    // returns true if title "Соберите бургер" is displayed
    public boolean isSetUpBurgerTitleDisplayed() {
        return setUpBurgerTitle.shouldBe(Condition.visible).isDisplayed();
    }

    // clicks Войти в аккаунт button
    public void clickLogInToAccountButton() {
        logInButton.shouldBe(Condition.exist).click();
    }
}

