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

public class TC04_AgregarProductoCarrito {

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
    public void miCuartaPrueba() throws InterruptedException {

        
        WebElement btnProducts = driver.findElement(By.xpath("//a[@href='/products']"));

        if (btnProducts.isDisplayed() && btnProducts.isEnabled()) {
            btnProducts.click();
            System.out.println("Se accedió a la sección Products");
        } else {
            System.out.println("El botón Products no está disponible");
        }

        Thread.sleep(2000);

        
        WebElement btnAddToCart = driver.findElement(By.xpath("//a[@data-product-id='2']"));

        if (btnAddToCart.isDisplayed() && btnAddToCart.isEnabled()) {
            btnAddToCart.click();
            System.out.println("Se agregó el producto con id 2 al carrito");
        } else {
            System.out.println("El botón Add to cart no está disponible");
        }

        Thread.sleep(2000);

        
        WebElement btnViewCart = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));

        if (btnViewCart.isDisplayed() && btnViewCart.isEnabled()) {
            btnViewCart.click();
            System.out.println("Se accedió al carrito");
        } else {
            System.out.println("El botón View Cart no está disponible");
        }

        Thread.sleep(3000);

        
        String paginaActual = driver.getPageSource();

        assertTrue(paginaActual.contains("Shopping Cart"));

        System.out.println("El producto se encuentra en el carrito correctamente");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}