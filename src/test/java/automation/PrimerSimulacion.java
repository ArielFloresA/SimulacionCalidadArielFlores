package automation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrimerSimulacion {

	private WebDriver driver; 
	
	@Before
	public void SetUp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	
	}
	
	@Test
	public void PrimeraPrueba () {
		
	}
	
	@After
    public void after() {
		
	}
	
}
