package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(css = "input#username")
    private WebElement emailTextfield;

    @FindBy(id = "reg_username")
    private WebElement registrationUsername;

    @FindBy(css = "input#password")
    private WebElement passwordTextfield;

    @FindBy(css = "[name='login']")
    private WebElement loginButton;

    @FindBy(css = ".form-group.form-error #email")
    private WebElement invalidEmail;

    @FindBy(id = "reg_email")
    private WebElement regUserMail;

    @FindBy(css = "input#reg_password")
    private WebElement regPassword;

    @FindBy(css = "button[name='register']")
    private WebElement createNewUserButton;

    @FindBy(css = "div.woocommerce-notices-wrapper ul.woocommerce-error")
    private WebElement errorMessage;

    @FindBy(css = "div.woocommerce-MyAccount-content")
    private WebElement myAccountContent;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public boolean isMyAccountContentDisplayed(){
        return myAccountContent.isDisplayed();
    }

    public void login(String email, String password) {
        emailTextfield.sendKeys(email);
        passwordTextfield.sendKeys(password);
        loginButton.click();
    }

    public void registerNewUser(String newUsername, String newEmailaddress, String newPassword){
        registrationUsername.sendKeys(newUsername);
        regUserMail.sendKeys(newEmailaddress);
        regPassword.sendKeys(newPassword);
        createNewUserButton.click();
    }

}
