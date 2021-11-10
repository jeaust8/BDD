package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ContactPage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@value='Ja']")
    private WebElement radioButtonYes;

    @FindBy(xpath = "//input[@value='Nee']")
    private WebElement radioButtonNo;

    @FindBy(xpath = "//input[@name='your-name']")
    private WebElement yourName;

    @FindBy(xpath = "//input[@name='your-email']")
    private WebElement yourEmail;

    @FindBy(xpath ="//input[@name='your-subject']" )
    private WebElement yourSubject;

    @FindBy(xpath = "//textarea[@name='your-message']")
    private WebElement yourMessage;

    @FindBy(xpath ="//input[@id='send-button']" )
    private WebElement sendButton;

    @FindBy(xpath = "//select[@name='your-department']")
    private WebElement dropDownListBox;

    @FindBy(xpath = "//div[contains(@class, 'response-output') and contains(text(), 'Bedankt')]")
    private WebElement responseMessageIfSend;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void fillInName(String name){
        yourName.sendKeys(name);

    }

    public void clickRadioButtonNo(){radioButtonNo.click();}

    public void clickRadioButtonYes(){
        radioButtonYes.click();
    }

    public void fillInEmail(String email){
        yourEmail.sendKeys(email);
    }

    public void fillInSubject(String subject){
        yourSubject.sendKeys( subject);
    }

    public void fillInMessage(String message){
        yourMessage.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void selectDepartment(String department){
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue(department);
    }
    public void selectCustomerSupport() {
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Klantenservice");
    }
    public void selectComplaintDepartment(){
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByValue("Klachtenafdeling");
    }
    public void fillContactFormWhenNotStayingInPark(String name, String subject, String email, String message, String department){
        clickRadioButtonNo();
        fillInName(name);
        fillInEmail(email);
        fillInSubject(subject);
        fillInMessage(message);
        selectDepartment(department);
        clickSendButton();
    }
    public void fillContactFormWhenStayingInPark(String name, String subject, String email, String message, String department){
        clickRadioButtonYes();
        fillInName(name);
        fillInEmail(email);
        fillInSubject(subject);
        fillInMessage(message);
        selectDepartment(department);
        clickSendButton();
    }

    public void fillComplaintForm(String name, String subject, String email, String message){
        clickRadioButtonYes();
        fillInName(name);
        fillInEmail(email);
        fillInSubject(subject);
        fillInMessage(message);
        selectComplaintDepartment();
        clickSendButton();
    }
    public boolean checkResponseMessage(){
        return responseMessageIfSend.isDisplayed();
    }
}