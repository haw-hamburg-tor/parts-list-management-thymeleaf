package org.hawhamburg.partslist.endtoend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateProductPage extends BasePage {

    private static final String ENDPOINT = "/create-product";

    @FindBy(css = "#productNameInput")
    private WebElement productNameInput;

    @FindBy(css = "#productPriceInput")
    private WebElement productPriceInput;

    @FindBy(css = "#componentNameInput")
    private WebElement componentNameInput;

    @FindBy(css = "#componentAmountInput")
    private WebElement componentAmountInput;

    @FindBy(css = "#addComponentButton")
    private WebElement addComponentButton;

    @FindBy(css = "#createProductButton")
    private WebElement createProductButton;

    public CreateProductPage(String baseURL, WebDriver webDriver) {
        super(baseURL, webDriver);
    }

    @Override
    protected String getEndpoint() {
        return ENDPOINT;
    }

    public void addComponent(String componentName, String amount) {
        componentNameInput.sendKeys(componentName);
        new Select(componentAmountInput).selectByValue(amount);
        addComponentButton.click();
    }

    public void creatProduct(String productName, String productPrice) {
        productNameInput.sendKeys(productName);
        productPriceInput.sendKeys(productPrice);
        createProductButton.click();

    }
}
