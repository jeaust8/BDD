package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "li.my-account a")
    private WebElement myAccountButton;

    @FindBys( { @FindBy(css = "section#recent-posts-2 li a") })
    private List<WebElement> recentPosts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccount() {
        myAccountButton.click();
    }

    public boolean recentPostPresent(String expectedPost) {
        List<String> recentPostsText = new ArrayList<>();
        for (WebElement recentPost : recentPosts) {
            recentPostsText.add(recentPost.getText());
        }
        return recentPostsText.contains(expectedPost);
    }
}
