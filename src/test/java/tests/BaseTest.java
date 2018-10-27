package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageGenerator;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

    @BeforeEach
    public void classLevelSetup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        page = new PageGenerator(driver);
    }

    @AfterEach
    public void teardown () {
        driver.quit();
    }
}
