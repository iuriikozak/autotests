package utilities;

import TestAutomation.TemplateMonster.utility.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by victorp on 09.04.15.
 */
public class FileReaderService {

    public static List<String> listReader(String fileLocation){
       BufferedReader in;
        List<String> myList = new ArrayList<>();
        try {
            in = new BufferedReader(new FileReader("src/test/resources/properties/"+fileLocation));
            String str;
            while ((str = in.readLine()) != null) {
                myList.add(str);
            }
            in.close();
        }
        catch (IOException e){
            Log.error("Catch an exception " + e);
        }

        return myList;
    }


    public static Map<String,String> getMap(String fileLocation){
        try {
            Map<String, String> map = new HashMap<>();
            BufferedReader in = new BufferedReader( new FileReader("src/test/resources/properties/"+fileLocation));
            String line;
            while ((line = in.readLine()) !=null){
                String parts[] = line.split("=");
                map.put(parts[0],parts[1]);
            }
            in.close();
            return map;
        }
        catch (IOException e){
            Log.error("Exception - " + e);
            return null;
        }

    }
}
