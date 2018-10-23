package itbootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class UltimateQa {
	//https://www.ultimateqa.com/sample-application-lifecycle-sprint-1/
	private static 	String url = "https://www.ultimateqa.com/simple-html-elements-for-automation/";
	
	public static void fillFirstName(WebDriver driver) throws InterruptedException {
		String url = "https://www.ultimateqa.com/sample-application-lifecycle-sprint-1/";
		driver.get(url);
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Sima");
		Thread.sleep(5000);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submitForm']"));
		submit.click();
		Thread.sleep(5000);
	}
	public static void fillFirstAndLastName(WebDriver driver) throws InterruptedException {
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
	}
	
	public static void fillFirstLastNameAndGender(WebDriver driver) throws InterruptedException {
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
	}	
	
	public static void logIn(WebDriver driver) throws InterruptedException {
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
	}
	//
	public static void logInWithIncorrectPassword(WebDriver driver) throws InterruptedException {
		driver.get(url);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Go to login page')]")).click();;
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
		String wrongPassword = "1234";
		password.sendKeys(wrongPassword);
		WebElement submit = driver.findElement(By.xpath("//input[@id='btn-signin']"));
		submit.click();
		WebElement errorElement = driver.findElement(By.xpath("//li[@class='notifications-error__list-item']"));
		String errorMessage = errorElement.getText();
		String expectedErrorMessage = "Invalid email or password.";
		if(errorMessage.equals(expectedErrorMessage))
		{
			System.out.println("Test pass - The correct error message is showned.");
		}
		else
		{
			System.out.println("Test failed - The incorrect error message is showned.");
		}
		Thread.sleep(5000);
	}
}

