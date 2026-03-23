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
import org.openqa.selenium.support.ui.Select;

public class TC02_RegistroCompletoUsuario {

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
    public void miSegundaPrueba() throws InterruptedException {

        
        WebElement btnSignupLogin = driver.findElement(By.xpath("//a[@href='/login']"));

        if (btnSignupLogin.isDisplayed() && btnSignupLogin.isEnabled()) {
            btnSignupLogin.click();
            System.out.println("Se accedió a Signup / Login");
        } else {
            System.out.println("El botón Signup / Login no está disponible");
        }

        Thread.sleep(2000);

        
        WebElement txtName = driver.findElement(By.name("name"));
        WebElement txtEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        WebElement btnSignup = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));

        String correoDinamico = "arielfa" + System.currentTimeMillis() + "@gmail.com";

        if (txtName.isDisplayed() && txtName.isEnabled()
                && txtEmail.isDisplayed() && txtEmail.isEnabled()
                && btnSignup.isDisplayed() && btnSignup.isEnabled()) {

            txtName.sendKeys("Ariel Flores");
            txtEmail.sendKeys(correoDinamico);
            btnSignup.click();

            System.out.println("Se ingresó el nombre y correo dinámico: " + correoDinamico);

        } else {
            System.out.println("Los campos de registro inicial no están disponibles");
        }

        Thread.sleep(3000);

        
        WebElement rdbMr = driver.findElement(By.id("id_gender1"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement cmbDays = driver.findElement(By.id("days"));
        WebElement cmbMonths = driver.findElement(By.id("months"));
        WebElement cmbYears = driver.findElement(By.id("years"));

        WebElement txtFirstName = driver.findElement(By.id("first_name"));
        WebElement txtLastName = driver.findElement(By.id("last_name"));
        WebElement txtCompany = driver.findElement(By.id("company"));
        WebElement txtAddress1 = driver.findElement(By.id("address1"));
        WebElement cmbCountry = driver.findElement(By.id("country"));
        WebElement txtState = driver.findElement(By.id("state"));
        WebElement txtCity = driver.findElement(By.id("city"));
        WebElement txtZipcode = driver.findElement(By.id("zipcode"));
        WebElement txtMobileNumber = driver.findElement(By.id("mobile_number"));
        WebElement btnCreateAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));

        
        if (rdbMr.isDisplayed() && rdbMr.isEnabled()) {
            rdbMr.click();
        }

        
        txtPassword.sendKeys("arielf123");

        
        Select selectDay = new Select(cmbDays);
        selectDay.selectByValue("11");

        Select selectMonth = new Select(cmbMonths);
        selectMonth.selectByVisibleText("November");

        Select selectYear = new Select(cmbYears);
        selectYear.selectByValue("2003");

        
        txtFirstName.sendKeys("Ariel");
        txtLastName.sendKeys("Flores");
        txtCompany.sendKeys("ICE");
        txtAddress1.sendKeys("San Juan");

        Select selectCountry = new Select(cmbCountry);
        selectCountry.selectByVisibleText("United States");

        txtState.sendKeys("Miami");
        txtCity.sendKeys("Long Island");
        txtZipcode.sendKeys("1212");
        txtMobileNumber.sendKeys("72345171");

        Thread.sleep(2000);

        
        if (btnCreateAccount.isDisplayed() && btnCreateAccount.isEnabled()) {
            btnCreateAccount.click();
            System.out.println("Se hizo clic en Create Account");
        } else {
            System.out.println("El botón Create Account no está disponible");
        }

        Thread.sleep(3000);

        
        String paginaActual = driver.getPageSource();

        assertTrue(paginaActual.contains("Account Created!"));

        System.out.println("La cuenta fue creada exitosamente");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
