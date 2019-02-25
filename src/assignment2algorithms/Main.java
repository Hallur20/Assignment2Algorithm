package assignment2algorithms;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    private static ArrayList<String> textFileList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        FileReaderLogic l = new FileReaderLogic();
        l.readFile(textFileList);

        ArraySymbolTable<String> st = new ArraySymbolTable();


        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
                st.put(key);
            }
        sw.stop();


        try {
            st.getAll();
        }
        catch(Exception e)
        {}


        System.out.println("time in milli seconds: "+sw.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: "+sw.getTime(TimeUnit.MICROSECONDS));
        System.out.println("time in nano seconds: "+sw.getTime(TimeUnit.NANOSECONDS));

     /*
    linked symbol table is... scans the hashmap if the key is already in use, if it is then replace with new value,
    do not continue scanning if key has been found.
    
    array symbol table is... (and what is flexible array) scan hashmap alphabeticaly where to put the key,
    if same key but diffirent value just replace value (key is still at same index).
    
    hashed symbol table is... hash value is the position in the hash table, while the keys should be unique in the hash position.
    
    balanced tree symbol table is...
    
    
    */
}}
