package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    //JAVA Generics to Create and return a New Page
    public <TPage extends BasePage> TPage getPage(Class<TPage> pageClass) {
        //Initialize the Page with its elements and return it.
        return PageFactory.initElements(driver, pageClass);
    }
}
