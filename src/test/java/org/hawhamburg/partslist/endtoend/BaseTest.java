package org.hawhamburg.partslist.endtoend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @LocalServerPort
    private int port;
    protected String baseURL;
    protected WebDriver webDriver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        this.baseURL = "http://localhost:" + port;
        var options = new ChromeOptions();
        // --headless is required to run selenium tests via GitHub actions
        options.addArguments("--headless");
        this.webDriver = new ChromeDriver(options);
    }

    @AfterEach
    public void afterEach() {
        if (this.webDriver != null) {
            this.webDriver.quit();
        }
    }
}
