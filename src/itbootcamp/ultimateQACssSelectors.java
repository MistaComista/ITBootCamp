package itbootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ultimateQACssSelectors {
	public static void fillFirstName(WebDriver driver) throws InterruptedException {

			String url = "https://www.ultimateqa.com/sample-application-lifecycle-sprint-3/";
			driver.get(url);
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input[value='male']")).click();;
			WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
			firstName.sendKeys("Sima");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Simic");
			Thread.sleep(5000);
			WebElement submit = driver.findElement(By.cssSelector("form[action='https://www.ultimateqa.com'] input[type='submit']"));
			submit.click();
			Thread.sleep(5000);
			driver.close();	
	}
	

}
