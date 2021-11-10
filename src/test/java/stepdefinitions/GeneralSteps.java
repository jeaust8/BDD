package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GeneralSteps {

    private final WebDriver driver;

    public GeneralSteps(World world){
        this.driver = world.getDriver();
    }

    @Given("I'm on the VGP Shop homepage")
    public void iMOnTheVGPShopHomePage(){
        driver.get("https://vgp-shop.polteq-testing.com/");
    }
}
