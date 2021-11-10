package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pages.HomePage;
//
//@Data
//public class Hooks {
//
//    private final World world;
//
//    public Hooks(World world){
//        this.world = world;
//    }
//
//    @Before
//    public void beforeScenario(){
//        // Create driver
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//
//        world.setDriver(new ChromeDriver(options));
//        world.setMyWaitVar(new WebDriverWait(world.getDriver(), 20));
//        world.setHomePage(new HomePage(world.getDriver()));
//
//    }
//
//    @After
//    public void afterScenario(){
//        world.getDriver().quit();
//    }
//
//
//}
