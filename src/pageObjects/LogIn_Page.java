 package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LogIn_Page {

	private static WebElement web_element = null;

	public static WebElement txtbx_UserName(WebDriver driver){
		web_element = driver.findElement(By.id("log"));
		return web_element;
		}

	public static WebElement txtbx_Password(WebDriver driver){
		web_element = driver.findElement(By.id("pwd"));
		return web_element;
		}

	public static WebElement btn_LogIn(WebDriver driver){

		web_element = driver.findElement(By.id("login"));
		return web_element;
		}

}