package SeleniumPractise.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2
{
    @Test
    public void Demo()
    {
        System.out.println("good");
        Assert.assertTrue(false);
    }
    @Test
    public void SecondTest()
    {
        System.out.println("Bye");
    }

    @BeforeTest
    public void prerwquiste()
    {
        System.out.println("I will execute BEFORE FRIST ");
    }


    @AfterTest
    public void prerwquiste1() {
        System.out.println("I will execute LAST");
    }

}
