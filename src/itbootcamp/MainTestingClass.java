package itbootcamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class MainTestingClass {

	public static void mainEx(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        //FirstLecture.Navigation();
		WebDriver driver = new ChromeDriver();
        TestingW3School.SwitchToNewTab(driver);
        driver.close();
		
	}

}
