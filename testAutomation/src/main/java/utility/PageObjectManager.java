package utility;

import PageObjects.*;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

   private WebDriver driver;
    public PageObjectManager(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public FlipcartHomePage getFlipcartHomePage(){
        FlipcartHomePage flipcartHomePage = new FlipcartHomePage(driver);
        return flipcartHomePage;
    }
}
