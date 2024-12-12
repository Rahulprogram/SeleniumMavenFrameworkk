package SeleniumPractise.Test;

import org.testng.annotations.*;

public class day4
{
    @Test
    public void webloginchomeloan()
    {
        System.out.println("webloginchomeloan");
    }

    @BeforeMethod
    public void beforemethodd()
    {
        System.out.println("I will execute before nethod");
    }
    @AfterMethod
    public void aftermethodd()
    {
        System.out.println("I will execute after mnethod");
    }

    public void methodName() {

    }
    @Test
    public void mobileloginhomeloan()
    {
        System.out.println("mobileloginhomeloan");
    }

    @Test
    public void loginapihomeloan()
    {
        System.out.println("loginapihomeloan");
    }

    @BeforeClass
    public void beforeclasses()
    {
        System.out.println("Executing before class");

    }

    @AfterClass
    public void afterclasses()
    {
        System.out.println("Executing after class");

    }
}
