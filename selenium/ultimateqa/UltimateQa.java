package itbootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;



public class UltimateQa {
	//https://www.ultimateqa.com/sample-application-lifecycle-sprint-1/
	public static void fillFirstName() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String url = "https://www.ultimateqa.com/sample-application-lifecycle-sprint-1/";
		driver.get(url);
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Sima");
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submitForm']"));
		submit.click();
		Thread.sleep(5000);
		driver.close();
	}
	public static void fillFirstAndLastName() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String url = "https://www.ultimateqa.com/sample-application-lifecycle-sprint-2/";
		driver.get(url);
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Sima");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Simic");
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.xpath("//form[@action='https://www.ultimateqa.com']//input[@type='submit']"));
		submit.click();
		Thread.sleep(5000);
		driver.close();	
	}
	
	public static void fillFirstLastNameAndGender() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String url = "https://www.ultimateqa.com/sample-application-lifecycle-sprint-3/";
		driver.get(url);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='male']")).click();
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Sima");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Simic");
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.xpath("//form[@action='https://www.ultimateqa.com']//input[@type='submit']"));
		submit.click();
		Thread.sleep(5000);
		driver.close();	
	}	
	
	public static void logIn() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String url = "https://www.ultimateqa.com/simple-html-elements-for-automation/";
		driver.get(url);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@value='male']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Go to login page')]")).click();;
		//WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://courses.ultimateqa.com/users/sign_in";
		if (currentUrl.equals(expectedUrl)){
			System.out.println("Verification Successful - The correct Url is opened.");
		}else{
			System.out.println("Verification Failed - The correct Url isn't opened.");
		}
		
		WebElement email = driver.findElement(By.xpath("//input[@id='user_email']"));
		email.sendKeys("svetislavsimic77@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
		password.sendKeys("itbootcamp");
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.xpath("//input[@id='btn-signin']"));
		submit.click();
		//WebElement submit = driver.findElement(By.xpath("//form[@action='https://www.ultimateqa.com']//input[@type='submit']"));
		Thread.sleep(5000);
		driver.close();	
	}
}

