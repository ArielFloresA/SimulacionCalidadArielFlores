package automation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC06_SuscripcionCorreo {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void miSextaPrueba() throws InterruptedException {

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        System.out.println("Se realizó scroll hacia la sección de suscripción");

        Thread.sleep(2000);

        
        WebElement txtEmail = driver.findElement(By.id("susbscribe_email"));
        WebElement btnSubscribe = driver.findElement(By.id("subscribe"));

        if (txtEmail.isDisplayed() && txtEmail.isEnabled()
                && btnSubscribe.isDisplayed() && btnSubscribe.isEnabled()) {

            txtEmail.sendKeys("arielf@gmail.com");
            btnSubscribe.click();

            System.out.println("Se ingresó el correo para suscripción");
        } else {
            System.out.println("Los elementos de suscripción no están disponibles");
        }

        Thread.sleep(3000);

        
        String paginaActual = driver.getPageSource();

        assertTrue(paginaActual.contains("You have been successfully subscribed!"));

        System.out.println("La suscripción fue realizada correctamente");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
