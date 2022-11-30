package org.hawhamburg.partslist.endtoend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ComponentOverviewPage extends BasePage {

    private static final String ENDPOINT = "/component-overview";
    public static final int NAME_COLUMN_INDEX = 0;
    public static final int PRICE_COLUMN_INDEX = 1;
    public static final int TOTAL_PRICE_COLUMN_INDEX = 2;
    public static final int TYPE_COLUMN_INDEX = 3;

    @FindBy(css = "th")
    private List<WebElement> tableHeaderElements;

    @FindBy(css = "td")
    private List<WebElement> tableContentElements;

    public ComponentOverviewPage(String baseURL, WebDriver webDriver) {
        super(baseURL, webDriver);
    }

    @Override
    protected String getEndpoint() {
        return ENDPOINT;
    }

    public List<List<String>> getTableRows() {

        List<List<String>> tableContents = new ArrayList<>();
        int rowLength = tableHeaderElements.size();
        List<String> tableRow = new ArrayList<>();

        for (int i = 0; i < tableContentElements.size(); i++) {
            tableRow.add(tableContentElements.get(i).getText());

            if (i % rowLength == (rowLength - 1)) {
                tableContents.add(tableRow);
                tableRow = new ArrayList<>();
            }
        }
        return tableContents;
    }

    public List<List<String>> getTableColumns() {

        List<String> nameColumn = new ArrayList<>();
        List<String> priceColumn = new ArrayList<>();
        List<String> totalPriceColumn = new ArrayList<>();
        List<String> typeColumn = new ArrayList<>();

        int rowLength = tableHeaderElements.size();

        for (int i = 0; i < tableContentElements.size(); i++) {
            String currentElement = tableContentElements.get(i).getText();
            int columnIndex = i % rowLength;
            switch (columnIndex) {
                case NAME_COLUMN_INDEX -> nameColumn.add(currentElement);
                case PRICE_COLUMN_INDEX -> priceColumn.add(currentElement);
                case TOTAL_PRICE_COLUMN_INDEX -> totalPriceColumn.add(currentElement);
                case TYPE_COLUMN_INDEX -> typeColumn.add(currentElement);
            }
        }
        return List.of(nameColumn, priceColumn, totalPriceColumn, typeColumn);
    }

    public List<String> getNameColumn() {
        return getTableColumns().get(NAME_COLUMN_INDEX);
    }

    public List<String> getPriceColumn() {
        return getTableColumns().get(PRICE_COLUMN_INDEX);
    }

    public List<String> getTotalPriceColumn() {
        return getTableColumns().get(TOTAL_PRICE_COLUMN_INDEX);
    }

    public List<String> getTypeColumn() {
        return getTableColumns().get(TYPE_COLUMN_INDEX);
    }
}
