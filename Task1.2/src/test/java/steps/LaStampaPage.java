package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaStampaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LaStampaPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Accetta']")
    private WebElement accetta;

    @FindBy(xpath="(//button/span[text() = 'Cerca']/ancestor::button)[2]")
    private WebElement cerca;

    @FindBy(xpath = "(//form/div/input)[1]")
    private WebElement input;

    @FindBy(xpath = "//form[@method]//button[@type='submit']")
    private WebElement submit;

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(tagName = "head")
    private WebElement header;

    @FindBy(xpath = "(//form/div/input)[1]")
    private WebElement placeHolder;

    public WebElement getHeader() {
        return header;
    }

    public WebElement getCerca() {
        return cerca;
    }

    public WebElement getAccetta() {
        return accetta;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getFooter() {
        return footer;
    }
    public WebElement getPlaceHolder() {
        return placeHolder;
    }
}
