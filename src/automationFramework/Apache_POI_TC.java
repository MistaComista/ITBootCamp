package automationFramework;

		import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

		import org.openqa.selenium.chrome.*;

		import pageObjects.*;

		import utility.Constant;
		import PageObjectsTest.*;

		// Import Package utility.*

		import utility.ExcelUtils;

		import appModules.SignIn_Action;

	public class Apache_POI_TC {

			private static WebDriver driver = null;

		public static void main(String[] args) throws Exception {

        //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
			
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(Constant.URL);

        SignIn_Action.Execute(driver);

        System.out.println("Login Successfully.");
/*        driver.findElement(By.xpath("//a[@id='nav-bar-business']//div[@class='v-btn__content']")).click();
        Thread.sleep(1000);
        BussinesPage.getAddNewBussines(driver).click(); 
        BussinesPage.SetBussinesName(driver, "Sima");
        BussinesPage.SetCountry(driver, "Serbia");
        Thread.sleep(10000);*/
        //testovi za ClientPage
      
        driver.findElement(By.xpath("//a[@id='nav-bar-clients']//div[@class='v-btn__content']")).click();
        Thread.sleep(2000);
        ClientsPageTest.SetUpExcel();
        ClientsPageTest.AddNewClientTest(driver);
        driver.quit();

        //This is to send the PASS value to the Excel sheet in the result column.

        //ExcelUtils.setCellData("Pass", 1, 3);

		}

	}