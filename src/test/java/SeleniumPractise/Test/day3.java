package SeleniumPractise.Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day3
{
    @Test
    public void weblogincarloan()
    {
        System.out.println("weblogincarloan");
    }
    @Test
    public void mobilelogincarloan()
    {
        System.out.println("mobilelogincarloan");
    }
    @Test
    public void mobilelogincarloan1()
    {
        System.out.println("mobilelogincarloan");
    }

    @BeforeSuite
    public void beforesuite()
    {
        System.out.println("I will execute before suite");

    }
    @AfterSuite
    public void afteresuite()
    {
        System.out.println("I will execute after suite");

    }



    @Test
    public void loginapicarloan()
    {
        System.out.println("loginapicarloan");
    }
}
