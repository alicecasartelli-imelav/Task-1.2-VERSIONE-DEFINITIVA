import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestSelenium {

    public static void main(String[] args) throws Exception {

//        da cercare chromeoptions -> dovete fare in modo che il test parta a schermo intero
//
//        qualsiasi elemento e o  azione che dovete fare vi serve il webdriver
//        cercate webdriver -> come istanziare il webdriver e passare le chromeoptions
//
//
//        per interagire con gli elementi dovete usare WebElement.. cercate questo e esplorate anche i suggerimenti di intellij. affidatevi alla doc di selenium disponibile online per tutti i metodi necessari

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lastampa.it/");

        driver.manage().window().fullscreen();              //full screen

        driver.manage().window().maximize();                //massimizza la finestra (MA pulsanti visibili)

        WebElement acceptButton = driver.findElement(By.xpath("//button[text()='Accetta']"));  //bottone accetta cookies

        Thread.sleep(5000);
        acceptButton.click();

        System.out.println("start counting");
        Thread.sleep(20000);

        //String footer="//footer/div/div[3]/p[normalize-space(text()=\"I diritti delle immagini e dei testi sono riservati. È espressamente vietata la loro riproduzione con qualsiasi mezzo e l'adattamento totale o parziale.\"]))";
        // salvare l'xpath come una variabile e usare la variabile

        String footer="//footer/div/div[3]/p"; //scrollare
        WebElement footer2 = driver.findElement(By.xpath(footer));
        System.out.println(footer2);
//
        new Actions(driver)
                .scrollToElement(footer2)
                .perform();



        WebElement cerca = driver.findElement(By.xpath("(//button/span[text() = 'Cerca']/ancestor::button)[2]"));
        cerca.click();
        // /ancestor + button/span[text() = 'Cerca'])[2]


        WebElement cercaNelSito = driver.findElement(By.xpath("(//form/div/input)[1]")); // input = TAG con @, placeholder = ATTRIBUTO
       //click sopra


        cercaNelSito.sendKeys("Milano");        //digita "Milano"

        WebElement inviaRicerca = driver.findElement(By.xpath("//form[@method]//button[@type='submit']"));
        inviaRicerca.click();


Thread.sleep(5000);
        System.out.println("benfayyo");

        driver.quit();

    }
}