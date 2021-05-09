package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.LogUtil;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "email")
    public WebElement userName;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    By loginButton            = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

    //*********Page Methods*********
    public LoginPage andILoginToN11(String userName, String password) {
        writeText(this.userName, userName);
        writeText(this.password, password);
        jsClick(loginButton);
        return this;
    }

    public LoginPage thenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public LoginPage thenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public LoginPage thenIVerifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }

}
