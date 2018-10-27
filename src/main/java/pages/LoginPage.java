package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "email")
    public WebElement username;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.ID, using = "loginButton")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[1]/div/div")
    public WebElement errorMessageUsername;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
    public WebElement errorMessagePassword;


    //*********Page Methods*********
    public LoginPage AndIloginToN11(String pusername, String ppassword){
        writeText(username,pusername);
        writeText(password, ppassword);
        click(loginButton);
        return this;
    }

    public LoginPage ThenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(readText(errorMessageUsername), expectedText);
        return this;
    }

    public LoginPage ThenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(readText(errorMessagePassword), expectedText);
        return this;
    }

}
