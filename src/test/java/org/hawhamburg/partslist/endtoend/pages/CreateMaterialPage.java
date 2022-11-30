package org.hawhamburg.partslist.endtoend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMaterialPage extends BasePage {

    private static final String ENDPOINT = "/create-material";

    @FindBy(css = "#materialNameInput")
    private WebElement materialNameInput;

    @FindBy(css = "#materialPriceInput")
    private WebElement materialPriceInput;

    @FindBy(css = "#createMaterialButton")
    private WebElement createMaterialButton;

    public CreateMaterialPage(String baseURL, WebDriver webDriver) {
        super(baseURL, webDriver);
    }

    @Override
    protected String getEndpoint() {
        return ENDPOINT;
    }

    public void createMaterial(String materialName, String  materialPrice) {
        materialNameInput.sendKeys(materialName);
        materialPriceInput.sendKeys(materialPrice);
        createMaterialButton.click();
    }
}
