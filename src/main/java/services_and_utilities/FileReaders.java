package services_and_utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaders {
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
            Logs.error("Catch an exception " + e);
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
            Logs.error("Exception - " + e);
            return null;
        }
    }
}
