package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SignInPage {
  private static WebElement element;
  
  public static WebElement getUserName(WebDriver driver)
  {
	  element = driver.findElement(By.xpath("//input[@id='login-form-email']"));
	  return element;
  }
  
  public static WebElement getPassword(WebDriver driver)
  {
	  element = driver.findElement(By.xpath("//input[@id='login-pass']"));
	  return element;
  }
  public static WebElement getLogIn(WebDriver driver)
  {
	  element = driver.findElement(By.xpath("//div[@class='v-btn__content']"));
	  return element;
  }
  public static void SetUserName(WebDriver driver, String userName)
  {
	  getUserName(driver).sendKeys(userName);
  }
  
  public static void SetPassword(WebDriver driver, String password)
  {
	  getPassword(driver).sendKeys(password);
  }
  public static void LogIn(WebDriver driver)
  {
	  getLogIn(driver).click();
  }
}
