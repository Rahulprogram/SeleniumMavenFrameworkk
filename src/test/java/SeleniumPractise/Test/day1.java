package SeleniumPractise.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1
{

    @Parameters({"URL"})
    @Test
    public void Demo(String name)
    {
        System.out.println("Hello");
        System.out.println(name);

    }
    @Test(dependsOnMethods = {"Demo"})
    public void SecondTest()
    {
        System.out.println("Bye");
    }

    @Test(enabled = false)
    public void ThirdTest()
    {
        System.out.println("ThirdBye");
    }


    @Test(timeOut = 2000)
    public void FourthTest()
    {
        System.out.println("FourthTest");
    }


    @Test(dataProvider = "getData")
    public void datatake(String usernmae, String password)
    {
        System.out.println(usernmae);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data= new Object[2][2];
        data[0][0]="firstusername";
        data[0][1]="firstpassword";

        data[1][0]="secondusername";
        data[1][1]="secondpassword";

        return data;

    }


}
