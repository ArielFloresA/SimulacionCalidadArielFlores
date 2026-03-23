package automation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC01_AccesoSignupLogin {

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
    public void miPrimeraPrueba() throws InterruptedException {

        
        WebElement btnSignupLogin = driver.findElement(By.xpath("//a[@href='/login']"));

        if (btnSignupLogin.isDisplayed() && btnSignupLogin.isEnabled()) {
            btnSignupLogin.click();
            System.out.println("Se hizo clic en Signup / Login");
        } else {
            System.out.println("El elemento no está disponible");
        }

        Thread.sleep(2000);

        String urlActual = driver.getCurrentUrl();
        String paginaActual = driver.getPageSource();

        System.out.println("URL actual: " + urlActual);

        assertTrue(urlActual.contains("/login"));
        assertTrue(paginaActual.contains("Login to your account"));
        assertTrue(paginaActual.contains("New User Signup!"));
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}