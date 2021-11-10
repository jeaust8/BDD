package stepdefinitions;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

@Data
public class World {

    private WebDriver driver;
    private WebDriverWait myWaitVar;
    private HomePage homePage;
}
