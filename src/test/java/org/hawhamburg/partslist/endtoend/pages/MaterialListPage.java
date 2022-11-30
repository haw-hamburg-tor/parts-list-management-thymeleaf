package org.hawhamburg.partslist.endtoend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MaterialListPage extends BasePage {

    private static final String ENDPOINT = "/material-list";

    private static final int NAME_COLUMN_INDEX = 0;
    private static final int AMOUNT_COLUMN_INDEX = 1;

    @FindBy(css = "#getMaterialListButton")
    private WebElement getMaterialListButton;

    @FindBy(css = "#productNameInput")
    private WebElement productNameInput;
    @FindBy(css = "th")
    private List<WebElement> tableHeaderElements;

    @FindBy(css = "td")
    private List<WebElement> tableContentElements;


    public MaterialListPage(String baseURL, WebDriver webDriver) {
        super(baseURL, webDriver);
    }

    @Override
    protected String getEndpoint() {
        return ENDPOINT;
    }

    public List<List<String>> getTableColumns() {

        List<String> nameColumn = new ArrayList<>();
        List<String> priceColumn = new ArrayList<>();

        int rowLength = tableHeaderElements.size();

        for (int i = 0; i < tableContentElements.size(); i++) {
            String currentElement = tableContentElements.get(i).getText();
            int columnIndex = i % rowLength;
            switch (columnIndex) {
                case NAME_COLUMN_INDEX -> nameColumn.add(currentElement);
                case AMOUNT_COLUMN_INDEX -> priceColumn.add(currentElement);
            }
        }
        return List.of(nameColumn, priceColumn);
    }

    public List<String> getNameColumn() {
        return getTableColumns().get(NAME_COLUMN_INDEX);
    }

    public List<String> getAmountColumn() {
        return getTableColumns().get(AMOUNT_COLUMN_INDEX);
    }

    public void getMaterialList(String name) {
        new Select(productNameInput).selectByValue(name);
        getMaterialListButton.click();
    }
}
