package pageObjects;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class BussinesPage {
private static WebElement element;
//
public static WebElement getAddNewBussines(WebDriver driver)
{
	element = driver.findElement(By.xpath("//i[contains(text(),'library_add')]"));
	return element;
}
public static WebElement getBussinesName(WebDriver driver)
{
	element = driver.findElement(By.xpath("//input[@id='business-form-name']"));
	return element;
}
public static WebElement getCountries(WebDriver driver)
{
	element = driver.findElement(By.xpath("//input[@id='business-form-country']"));
	return element;
}
public static WebElement getCity(WebDriver driver)
{
	element = driver.findElement(By.xpath("//input[@id='business-form-city']"));
	return element;
}
public static WebElement getStreet(WebDriver driver)
{
	element = driver.findElement(By.xpath("//input[@id='business-form-street']"));
	return element;
}
public static WebElement getZip(WebDriver driver)
{
	element = driver.findElement(By.xpath("//label[contains(text(),'Zip')]"));
	return element;
}
public static WebElement getRegistryNumber(WebDriver driver)
{
	element = driver.findElement(By.xpath("//label[contains(text(),'Registry Number')]"));
	return element;
}

public static List<WebElement> getCountryList(WebDriver driver)
{
	List<WebElement> l = driver.findElements(By.xpath("//*[@id=\"app\"]/div[3]/div/div"));
	return l;
}


public static void SetBussinesName(WebDriver driver, String bussinesName)
{
	getBussinesName(driver).sendKeys(bussinesName);
	return;
}
//@FindBy(css = "span[class='v-list__tile__mask']")
public static void SetCountry(WebDriver driver, String countryName) throws InterruptedException
{   
Actions builder = new Actions(driver);
Actions country = builder
.moveToElement(getCountries(driver))
.click()
.sendKeys(countryName);
country.sendKeys(Keys.DOWN).sendKeys(Keys.RETURN);
country.perform();
}
}
