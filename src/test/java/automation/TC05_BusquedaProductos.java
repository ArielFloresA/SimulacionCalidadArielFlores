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

public class TC05_BusquedaProductos {

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
    public void miQuintaPrueba() throws InterruptedException {

        
        WebElement btnProducts = driver.findElement(By.xpath("//a[@href='/products']"));

        if (btnProducts.isDisplayed() && btnProducts.isEnabled()) {
            btnProducts.click();
            System.out.println("Se accedió a la sección Products");
        } else {
            System.out.println("El botón Products no está disponible");
        }

        Thread.sleep(2000);

        
        WebElement txtBuscar = driver.findElement(By.id("search_product"));
        WebElement btnBuscar = driver.findElement(By.id("submit_search"));

        if (txtBuscar.isDisplayed() && txtBuscar.isEnabled()
                && btnBuscar.isDisplayed() && btnBuscar.isEnabled()) {

            txtBuscar.sendKeys("Blue Top");
            btnBuscar.click();

            System.out.println("Se realizó la búsqueda del producto: Blue Top");
        } else {
            System.out.println("Los elementos de búsqueda no están disponibles");
        }

        Thread.sleep(3000);

        
        String paginaActual = driver.getPageSource();

        assertTrue(paginaActual.contains("Searched Products"));
        assertTrue(paginaActual.contains("Blue Top"));

        System.out.println("La búsqueda de productos fue exitosa");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
