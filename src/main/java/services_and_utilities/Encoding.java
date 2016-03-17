package services_and_utilities;

import java.io.UnsupportedEncodingException;

public class Encoding {
    public  static String convertUTF(String origin){
        String convert = null;
        try {
            convert = new String(origin.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            Log.error(e.toString());
        }
        return convert;
    }
}
