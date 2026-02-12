package steps;

//in steps create una classe chiamata LaStampaSteps.java.
//
//qui andate a mappare gli elementi con @findby, create i metodi che vi servono e annotateli con @And, @Given e @Then.
//
//come bonus: cercate di rendere riutilizzabile il codice. una singola funzione -> usandola più volte eg. click o findelement


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaStampaSteps {



    //    concetto chiave -> WebDriver -> devi prendere un Chrome Driver con new
//    vai a istanziare ( creare un oggetto partendo da zero, inttelij lo usa)
//
    private WebDriver driver;
    //PageFactory.initElements(driver);
    private LaStampaPage stampaPage;

    private WebDriverWait wait;

    private JavascriptExecutor js;

    @Before
    public void setup() {
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        stampaPage=new LaStampaPage(driver, wait);
        js= (JavascriptExecutor) driver;
    }

    @Given("L'utente naviga sul sito La Stampa")
    public void lUtenteNavigaSulSitoLaStampa() {
        driver.get("https://www.lastampa.it/");
    }

    @And("I open full screen")
    public void iOpenFullScreen() {
        System.out.println("hrllo");
    }

    @Then("I Wait {} Seconds")
        public void iWaitFiveSeconds(int ms) {
        try {
            System.out.println("Aspetto per " + ms);
            Thread.sleep(ms*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("I click button")
    public void iClickAGeneralBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(stampaPage.getAccetta()));
        stampaPage.getAccetta().click();
    }

    @And("I scroll to bottom")
    public void iScrollToBottom() {
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @And("I scroll to top")
    public void iScrollToTop() {
        js.executeScript("window.scrollTo(0,0)", stampaPage.getHeader());
    }

    @And("I click cerca button")
    public void iClickCercaButton(){
        stampaPage.getCerca().click();
        System.out.println("Ho scrollato");
    }

    @Then("I write {} on research bar")
    public void IWriteMilanoOnResearchBar(String testoDaCercare) {
        stampaPage.getPlaceHolder().sendKeys(testoDaCercare);
        stampaPage.getPlaceHolder().sendKeys(Keys.ENTER);
    }
  }