/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package messageparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author ULVI
*/
public class MessageParser {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    // TODO code application logic here
    read();
}


private static void read(){
    Map<String,List<String>> mapForPerson = new HashMap<>();
    List<String> messages;
    try {
        FileReader fileReader = new FileReader("your file path");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String text;
        
        while((text = bufferedReader.readLine())!= null){
            text = text.split("-")[1];
            if(text.contains(":")){                   
                if (!mapForPerson.keySet().contains(getName(text))) {
                    messages = new ArrayList<String>();
                    messages.add(getMessage(text));
                    mapForPerson.put(getName(text), messages);
                }else{
                    messages = mapForPerson.get(getName(text));
                    messages.add(getMessage(text));
                    mapForPerson.put(getName(text), messages);
                }
            }
       }
         
        System.out.println("size-->"+mapForPerson.size());
        for(Map.Entry<String, List<String>> entry : mapForPerson.entrySet()  )
        {
        System.out.println(entry.getKey()+"----"+entry.getValue()+"\n");
              
        }
    }  catch (IOException ex) {
        System.out.println("File not fount");
    }
}


private static String getName(String text){
    return text.split(":",2)[0];
}

private static String getMessage(String text){
    return text.split(":",2)[1];
}


}
