package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait myWaitVar;
    private HomePage homePage;

public StepDefinitions(World world){
    driver = world.getDriver();
    myWaitVar = world.getMyWaitVar();
    homePage = world.getHomePage();
}

    @Given("I'm on the VGP Shop homepage")
    public void iMOnTheVGPShopHomepage() {
        // Open the website
        driver.get("https://vgp-shop.polteq-testing.com/");
        driver.manage().window().maximize();
    }

    @When("I go to the shop")
    public void iGoToTheShop() {
        // -- @When( "I go to the SHOP" )
        driver.findElement(By.cssSelector("li.my-shop a")).click();
    }

    @And("I go to the Hoodie with logo detail page")
    public void iGoToTheHoodieWithLogoDetailPage() {
        // -- @And( "I go to the Hoodie with logo detail page" )
        driver.findElement(By.xpath("//h2/a[contains(text(),'Hoodie with Logo')]")).click();
    }

    @And("I add the Hoodie with logo to the cart")
    public void iAddTheHoodieWithLogoToTheCart() {
        // -- @And( "I add the Hoodie with lo to the cart" )
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();
    }

    @Then("I should get a conformation that the product is added to the shopping cart")
    public void iShouldGetAConformationThatTheProductIsAddedToTheShoppingCart() {
        // -- @Then( "I should get a confirmation that the product is added to the shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message")));
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.cssSelector(".woocommerce-message")).isDisplayed());
    }

    @But("I should not be taken directly to my shopping cart")
    public void iShouldNotBeTakenDirectlyToMyShoppingCart() {
        // -- @But( "I should not be taken directly to my shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.checkout")));
        Assert.assertTrue("Check if the button to be taken to the checkout is shown",
                driver.findElement(By.cssSelector("a.button.checkout")).isDisplayed());
    }


    @When("I log in with valid credentials")
    public void iLogIn() {
        homePage.clickMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login("tester@polteq-testing.com", "1!QazXsw2@");
    }

    @Then("I should see my username appear on top of the page")
    public void iShouldSeeMyUserNameAppearOnTopOfThePage() {
        Assert.assertTrue(
                "username should be in welcome message",
                driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content")).getText().contains("TesterAtPolteqTesting")
        );
    }

    @When("I go to the {string} page")
    public void iGoToThePage(String arg0) {
    }

    @And("I go to the {string} detail page")
    public void iGoToTheDetailPage(String arg0) {
    }

    @And("I increase the quantity to {int}")
    public void iIncreaseTheQuantityTo(int arg0) {
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
    }

    @And("the conformation shows quantity is {int}")
    public void theConformationShowsQuantityIs(int arg0) {
    }

    @When("^I login as \"(.*)\" with password \"(.*)\"$")
    public void iLoginAsWithPassword (String email, String password) {
        homePage.clickMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login(email, password);
    }

    @Then("^I should see my username \"(.*)\" appear on top of the page$")
    public void iShouldSeeMyUsernameAppearOnTopOfThePage(String username) {
        Assert.assertTrue("username should be in welcome message",
                driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content")).getText().contains(username));
    }

    @When("^I create a new account with username \"(.*)\", mailaddress \"(.*)\" and with password \"(.*)\"$")
    public void iCreateANewAccountWithUsernameMailaddressAndWithPassword(String registrationUsername, String newUserMail, String newPassword) {
        homePage.clickMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerNewUser(registrationUsername, newUserMail, newPassword);
    }


    @Given("I'm at to the VGP shop-page")
    public void iMAtToThe() {
        driver.get("https://vgp-shop.polteq-testing.com/mijn-account/");
        driver.manage().window().maximize();
    }

    @When("^I login with \"(.*)\" and \"(.*)\"$")
    public void iLoginWithAnd(String username, String password) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login(username, password);

    }

    @Then("^My Account will be \"(.*)\"$")
    public void myAccountWillBe(String validity) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        if (validity.equals("valid")){
            Assert.assertTrue(myAccountPage.isMyAccountContentDisplayed());
        }
        else if(validity.equals("invalid")){
            Assert.assertTrue(myAccountPage.isErrorMessageDisplayed());
        }
        else {
            Assert.fail("oops!");
        }

    }
            @Then("the most recent posts should be visible")
            public void theMostRecentPostsShouldBeVisible(DataTable table) {
                List<Map<String, String>> expectedTitles = table.asMaps(String.class, String.class);
                // for loop
                for (int i = 0; i < expectedTitles.size(); i++) {
                    Assert.assertTrue(homePage.recentPostPresent(expectedTitles.get(i).get("Title")));
                }
                // foreach loop
                for (Map<String, String> expectedTitle : expectedTitles) {
                    Assert.assertTrue(homePage.recentPostPresent(expectedTitle.get("Title")));
                }

            }

    @Given("I'm on the contact page")
    public void iMOnTheContactPage() {
        driver.get("https://vgp-shop.polteq-testing.com/contactformulier/");
        driver.manage().window().maximize();
    }

    @When("I fill in the form with data from tables")
    public void iFillInTheFormWithDataFromTables(DataTable table) throws InterruptedException {
        List<Map<String, String>> contactInformations = table.asMaps(String.class, String.class);
        ContactPage contactPage = new ContactPage(driver);
        for (Map<String, String> contactInformation : contactInformations) {
            switch (contactInformation.get("Stay in park")) {
                case "Ja":
                    contactPage.fillContactFormWhenStayingInPark(
                            contactInformation.get("Name"),
                            contactInformation.get("Subject"),
                            contactInformation.get("Emailaddress"),
                            contactInformation.get("Message"),
                            contactInformation.get("Contact"));
                    myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'response-output')]")));
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case "Nee":
                    contactPage.fillContactFormWhenNotStayingInPark(
                            contactInformation.get("Name"),
                            contactInformation.get("Subject"),
                            contactInformation.get("Emailaddress"),
                            contactInformation.get("Message"),
                            contactInformation.get("Contact"));
                    myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'response-output')]")));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + contactInformation.get("Stay in park"));
            }
        }
    }
    @Given("I'm on the VGP json page")
    public void iMOnTheVGPJsonPage() {
        given().baseUri("https://vgp-shop.polteq-testing.com/wp-json/wp/v2/");
    }

    @When("^I perform a get from \"(.*)\"$")
    public void iPerformAGetFrom(String posts) {
        given().baseUri("https://vgp-shop.polteq-testing.com/wp-json/wp/v2/")
                .and().basePath("posts")
                .when().get("141");
    }

    @Then("^I should get status \"(.*)\"$")
    public void iShouldGetStatus(String posts) {
        given().baseUri("https://vgp-shop.polteq-testing.com/wp-json/wp/v2/")
                .and().basePath("posts")
                .when().get("141")
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_OK);

    }

    @Then("I should see a conformation message")
    public void iShouldSeeAConformationMessage() {
        ContactPage contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.checkResponseMessage());
    }
}
