package utilities;

import TestAutomation.TemplateMonster.utility.Log;

import java.io.UnsupportedEncodingException;

/**
 * Created by victorp on 16.04.15.
 */
public class EncodingService {

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
