package hsenid;

import java.util.Scanner;

/**
 * Created by Menuka Ishan on 3/21/16.
 */
public class StrChng {
    /**
     * This class replace the spaces of given string with %20 (space character in html)
     * @param x
     * This is the original string from translate.jsp which we want to translate
     * @return
     * It return the modified string.
     */
    public String modifiedStr(String x){


        String[] array = x.split("\\s+",-1);

        String modify="";

        for (String xy: array){
            modify += xy + "%20";
        }
        return modify;

    }
    
    

}
