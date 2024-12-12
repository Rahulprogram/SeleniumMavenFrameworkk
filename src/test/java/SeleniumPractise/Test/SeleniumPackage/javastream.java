package SeleniumPractise.Test.SeleniumPackage;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class javastream
{
    @Test
    public void stream()
    {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Charu");
        names.add("Rahul");
        names.add("Rawat");
        names.add("Chitranshi");


        Long c=names.stream().filter(s->s.startsWith("R")).count();
        System.out.println(c);
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));

         /*
       Long c= Stream.of("Rahul","Rawat").filter(s->s.startsWith("R")).count();
        System.out.println(c);
        */


    }
}
