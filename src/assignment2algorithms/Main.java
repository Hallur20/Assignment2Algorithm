package assignment2algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class Main {

    private static ArrayList<String> textFileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileReaderLogic l = new FileReaderLogic();
        l.readFile(textFileList);
        /* for (int i = 0; i < textFileList.size(); i++) {
            System.out.println(textFileList.get(i));
        }*/

        ArrayList<String> hardcodedWords = new ArrayList<>();
        hardcodedWords.add("a");
        hardcodedWords.add("x");
        hardcodedWords.add("x");
        hardcodedWords.add("x");
        hardcodedWords.add("b");
        hardcodedWords.add("m");
        hardcodedWords.add("b");

        String toBe = "to be or not to be, that is the question";
        toBe = toBe.replace(",", "");
        String[] splitted = toBe.split(" ");
        System.out.println(splitted.length);

        HashedSymbolTable<String, Integer> h = new HashedSymbolTable<>(textFileList.size());
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if (h.contains(key)) {
                h.put(key, h.get(key) + 1);
                continue;
            }
            h.put(key, 1);
        }
        s.stop();
        boolean allWordsExist = true;
        for (int i = 0; i < textFileList.size(); i++) {
          
            if (!h.contains(textFileList.get(i))) {
                System.out.println(textFileList.get(i) + " was not in there...");
                allWordsExist = false;
            }
            
        }
        if(!allWordsExist){
            System.out.println("if this is printed, some words were missing...");
        }
        h.printHashMap(h);
        System.out.println("time in minutes: " + s.getTime(TimeUnit.MINUTES));
        System.out.println("time in seconds: "+s.getTime(TimeUnit.SECONDS));
        System.out.println("time in milli seconds: " + s.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: " + s.getTime(TimeUnit.MICROSECONDS));

        /*
    linked symbol table is... scans the hashmap if the key is already in use, if it is then replace with new value,
    do not continue scanning if key has been found.
    
    array symbol table is... (and what is flexible array) scan hashmap alphabeticaly where to put the key,
    if same key but diffirent value just replace value (key is still at same index).
    
    hashed symbol table is... hash value is the position in the hash table, while the keys should be unique in the hash position.
    
    balanced tree symbol table is...
    
    
         */
    }
}
