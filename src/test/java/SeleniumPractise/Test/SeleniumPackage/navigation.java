package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class navigation
{
  @Test
  public void  windowwactivities()
  {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
      driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
      driver.navigate().back();
      driver.navigate().forward();

      driver.close();


  }
}
