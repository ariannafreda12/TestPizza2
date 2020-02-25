package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPizzaMargherita {

	@Test
	void testMargherita() {
		String s="The pizza Margherita is awseome";
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.deepl.com/it/translator");
			
		driver.findElement(By.xpath("//*[@id=\"dl_translator\"]/div[1]/div[2]/div[2]/div/textarea")).sendKeys("The pizza Margherita is awseome");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@id=\"dl_translator\"]/div[1]/div[3]/div[3]/div[1]/textarea"));
		
		String trad = TxtBoxContent.getAttribute("value");
		
		assertEquals(s.length(),trad.length());
		
		
		

		driver.close();
	}
}

