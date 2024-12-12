package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamicdropdown
{
    @Test
    public void dynamicdropdwonselect()  {
        WebDriver dr = new ChromeDriver();
        dr.get("https://rahulshettyacademy.com/dropdownsPractise/");

        dr.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //dr.findElement(By.xpath("//a[@value='BLR']")).click();
        //Parent Child Relationship
        dr.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        System.out.println(dr.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).getText());

        //dr.findElement(By.xpath("(//a[@value='COK'])[2]")).click();
        dr.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).click();
        System.out.println(dr.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).getText());
        dr.close();

}}
