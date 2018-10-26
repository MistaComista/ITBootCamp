package itbootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class TestingW3School {
	private static String MessageFor = 
			"<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<title>Zdravo Camperi</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<h1>Kako ste?</h1>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	public static void WorkingWithSwitchTo(WebDriver driver)
	{
		String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
		driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        //Find "Try it" button
        WebElement alertButton = driver.findElement(By.cssSelector("html>body>button"));
        //Click alert button ("Try it" button)
        alertButton.click();
        //Alert Message (Expected Text)
        String expectedAlertMessage = "I am an alert box!";
        //Captured Alert Text (Actual Text)
        String actualAlertMessage = driver.switchTo().alert().getText();
        //Assertion
		if(actualAlertMessage.equals(expectedAlertMessage))
		{
			System.out.println("Test pass - The correct alert message is showned.");
		}
		else
		{
			System.out.println("Test failed - The incorrect alert message is showned.");
		}
        //Accept the alert (Click OK)
        driver.switchTo().alert().accept();
		
	}
	
	public static void SwitchToNewTab(WebDriver driver) throws InterruptedException
	{
		String url = "https://www.w3schools.com/html/default.asp";
		driver.get(url);
        driver.manage().window().maximize();
        String handle= driver.getWindowHandle();
        System.out.println(handle);
        WebElement tryItBtn = driver.findElement(By.xpath("//a[@class='w3-btn w3-margin-bottom']"));
        tryItBtn.click();
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
        WebElement runIt = driver.findElement(By.xpath("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']"));
        runIt.click();
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(handle);
		
	}
	
	//iframecontainer
	
	public static void SwitchToNewTabAndChangeHTML(WebDriver driver) throws InterruptedException
	{
		String url = "https://www.w3schools.com/html/default.asp";
		driver.get(url);
        driver.manage().window().maximize();
        String handle= driver.getWindowHandle();
        System.out.println(handle);
        WebElement tryItBtn = driver.findElement(By.xpath("//a[@class='w3-btn w3-margin-bottom']"));
        tryItBtn.click();
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
        WebElement textEditor = driver.findElement(By.xpath("//div[@id='editorEdit']"));
        System.out.println(textEditor.getText());
        textEditor.clear();
        textEditor.sendKeys(MessageFor);
        WebElement runIt = driver.findElement(By.xpath("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']"));
        runIt.click();
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(handle);
		
	}
}
