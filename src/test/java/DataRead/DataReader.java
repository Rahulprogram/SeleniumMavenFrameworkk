package DataRead;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.io
        .FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
public class DataReader
{
    public List<HashMap<String, String>> getJsonDataToHasmap() throws IOException {
        //Reading json to string
       String jsoncontent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\DataRead\\Purchase.json"), StandardCharsets.UTF_8);
       //String to Hashmap
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>()
        {
        });
        return data;

    }
}
