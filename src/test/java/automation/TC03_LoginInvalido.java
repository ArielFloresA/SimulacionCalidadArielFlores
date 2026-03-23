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

public class TC03_LoginInvalido {

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
    public void miTerceraPrueba() throws InterruptedException {

        WebElement btnSignupLogin = driver.findElement(By.xpath("//a[@href='/login']"));

        if (btnSignupLogin.isDisplayed() && btnSignupLogin.isEnabled()) {
            btnSignupLogin.click();
            System.out.println("Se accedió a Signup / Login");
        } else {
            System.out.println("El botón Signup / Login no está disponible");
        }

        Thread.sleep(3000);

        WebElement txtEmailLogin = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement txtPasswordLogin = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

        if (txtEmailLogin.isDisplayed() && txtEmailLogin.isEnabled()
                && txtPasswordLogin.isDisplayed() && txtPasswordLogin.isEnabled()
                && btnLogin.isDisplayed() && btnLogin.isEnabled()) {

            txtEmailLogin.sendKeys("arielfa@gmail.com");
            txtPasswordLogin.sendKeys("arielf1234");
            btnLogin.click();

            System.out.println("Se ingresaron credenciales inválidas");
        } else {
            System.out.println("Los elementos del login no están disponibles");
        }

        Thread.sleep(3000);

        String paginaActual = driver.getPageSource();

        assertTrue(paginaActual.contains("Your email or password is incorrect!"));

        System.out.println("El sistema mostró el mensaje de error esperado");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
