package itbootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;




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
	
	public static void FiilTheForm(WebDriver driver) throws InterruptedException {
		String url = "https://www.ultimateqa.com/filling-out-forms/";
		driver.get(url);
		WebElement nameField = driver.findElements(By.xpath("//input[@id='et_pb_contact_name_1']")).get(0);
		nameField.clear();
		nameField.sendKeys("test");
		WebElement textBox = driver.findElements(By.xpath("//textarea[@id='et_pb_contact_message_1']")).get(0);
		textBox.clear();
		textBox.sendKeys("testing");
		WebElement submit = driver.findElements(By.xpath("//button[@type='submit'][contains(text(),'Submit')]")).get(0);
		submit.click();
		Thread.sleep(5000);
	}
	
	public static void FiilTheFormWithCaptcha(WebDriver driver) throws InterruptedException {
		String url = "https://www.ultimateqa.com/filling-out-forms/";
		driver.get(url);
		WebElement nameField = driver.findElements(By.xpath("//input[@id='et_pb_contact_name_1']")).get(1);
		nameField.clear();
		nameField.sendKeys("test");
		WebElement textBox = driver.findElements(By.xpath("//textarea[@id='et_pb_contact_message_1']")).get(1);
		textBox.clear();
		textBox.sendKeys("testing");
		WebElement captcha = driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
		String captchaText = captcha.getText();
		String[] parts = captchaText.split("\\+");
		Thread.sleep(5000);
		Integer first = Integer.parseInt(parts[0].trim()); 
		System.out.println(String.format("Prvi argument %d", first));
		Integer second = Integer.parseInt(parts[1].trim()); 
		System.out.println(String.format("Drugi argument %d", second));
		Integer result = first + second;
		WebElement captchaResult = driver.findElement(By.xpath("//input[@name='et_pb_contact_captcha_1']"));
		captchaResult.sendKeys(result.toString());
		
		WebElement submit = driver.findElements(By.xpath("//button[@type='submit'][contains(text(),'Submit')]")).get(1);
		submit.click();
		Thread.sleep(5000);
	}


	public static void WorkingWithAlerts(WebDriver driver)
	{
		String urlQA="http://toolsqa.com/automation-practice-switch-windows/";
		//String urlW3 = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
		driver.get(urlQA);
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='alert']"));
		alertButton.click();
        String expectedAlertMessage = "Knowledge increases by sharing but not by saving";
        
        //Captured Alert Text (Actual Text)
        String actualAlertMessage = driver.switchTo().alert().getText();
        String[] sentences = actualAlertMessage.split("\\.");
        String firstSentenceAlert = sentences[0];
		if(firstSentenceAlert.equals(expectedAlertMessage))
		{
			System.out.println("Test pass - The correct alert message is showned.");
		}
		else
		{
			System.out.println("Test failed - The incorrect alert message is showned.");
		}
        driver.switchTo().alert().accept();
		
	}
	
	
	public static void AcceptAlertWithWait(WebDriver driver) throws InterruptedException {
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//button[@id='timingAlert']")).click();
		System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
		 
        // Create new WebDriver wait
		//WebDriverWait(IWebDriver, TimeSpan)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Wait for Alert to be present
        //until
        /*Repeatedly applies this instance's input value to the given function until one of the following occurs:
        the function returns neither null nor false
        the function throws an exception that is not in the list of ignored exception types
        the timeout expires
         */
        //public static ExpectedCondition<Alert> alertIsPresent()
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Either Pop Up is displayed or it is Timed Out");
        // Accept the Alert
        //wait util end of time
        myAlert.accept();
        System.out.println("Alert Accepted");
	
	}
	
	public static void SwitchToPopUpWindow(WebDriver driver) throws InterruptedException {
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
        driver.get(url);

        // Store and Print the name of the First window on the console
        String handle= driver.getWindowHandle();
        System.out.println(handle);
        // Click on the Button "New Message Window"
        driver.findElement(By.xpath("//button[contains(@onclick,'newMsgWin()')]")).click();

        // Store and Print the name of all the windows open	              

        Set<String> handles = driver.getWindowHandles();

        System.out.println(handles);

        // Pass a window handle to the other window

        for (String handle1 : driver.getWindowHandles()) {

        	System.out.println(handle1);
			if(!handle1.equals(handle))
			{
				driver.switchTo().window(handle1);
			}
        }

        // Closing Pop Up window
        //Thread.sleep(10000);
        driver.close();
        driver.switchTo().window(handle);
	}
}

