package SeleniumPractise.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day5
{
    @Test(groups = "smoke")
    public void Demo()
    {
        System.out.println("Hello");
    }
    @Test(groups="sanity")
    public void demo2()
    {
        System.out.println("Bye");
    }
    @Test(groups="sanity")
    public void demo3()
    {
        System.out.println("Bye");
    }
    @Test(groups="sanity")
    public void demo4()
    {
        System.out.println("Bye");
    }

}
