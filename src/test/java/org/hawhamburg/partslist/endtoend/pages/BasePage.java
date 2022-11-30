package org.hawhamburg.partslist.endtoend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final String baseURL;
    protected final WebDriver webDriver;

    protected BasePage(String baseURL, WebDriver webDriver) {
        this.baseURL = baseURL;
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected abstract String getEndpoint();

    public void load() {
        webDriver.get(baseURL + getEndpoint());
    }
}
