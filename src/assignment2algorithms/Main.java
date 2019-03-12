package assignment2algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class Main {

    private static ArrayList<String> textFileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileReaderLogic l = new FileReaderLogic();
        l.readFile(textFileList);

        HashedSymbolTable<String, Integer> hashedSymbolTable = new HashedSymbolTable<>();
        SequentialSearchST<String, Integer> sequentialSearchST = new SequentialSearchST<>();
        ArraySymbolTable<String> arraySymbolTable = new ArraySymbolTable();
        BalancedTreeTable<String, Integer> balancedTreeTable = new BalancedTreeTable<>();

        //---------------------------------------------------------------------//
               /*Hashed Symbol Table*/
        //timeHashedSymbolTable(hashedSymbolTable);
        
               /*Linked Symbol Table*/
        //timeLinkedSymbolTable(sequentialSearchST);
        
               /*Array Symbol table*/
        //timeArraySymbolTable(arraySymbolTable);
        
               /*Balanced Tree Symnbol Table*/
        timeBalancedTreeSymbolTable(balancedTreeTable);
    }

    public static void timeHashedSymbolTable(HashedSymbolTable<String, Integer> m) {
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if (m.contains(key)) {
                m.put(key, m.get(key) + 1);
                continue;
            }
            m.put(key, 1);
        }
        s.stop();
        m.printHashMap(m);
        System.out.println("time in minutes: " + s.getTime(TimeUnit.MINUTES));
        System.out.println("time in seconds: " + s.getTime(TimeUnit.SECONDS));
        System.out.println("time in milli seconds: " + s.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: " + s.getTime(TimeUnit.MICROSECONDS));
    }

    public static void timeLinkedSymbolTable(SequentialSearchST<String, Integer> m) {
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if (m.contains(key)) {
                m.put(key, m.get(key) + 1);
                continue;
            }
            m.put(key, 1);
        }
        s.stop();
        for (String st : m.keys()) {
            System.out.println(st + " " + m.get(st));
        }
        System.out.println("time in minutes: " + s.getTime(TimeUnit.MINUTES));
        System.out.println("time in seconds: " + s.getTime(TimeUnit.SECONDS));
        System.out.println("time in milli seconds: " + s.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: " + s.getTime(TimeUnit.MICROSECONDS));
    }

    public static void timeArraySymbolTable(ArraySymbolTable m) {
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            m.put(key);
        }
        s.stop();
        try {
            m.getAll();
        }
        catch(Exception e)
        {}
        System.out.println("time in minutes: " + s.getTime(TimeUnit.MINUTES));
        System.out.println("time in seconds: " + s.getTime(TimeUnit.SECONDS));
        System.out.println("time in milli seconds: " + s.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: " + s.getTime(TimeUnit.MICROSECONDS));
    }

    public static void timeBalancedTreeSymbolTable(BalancedTreeTable<String, Integer> m) {
        StopWatch s = new StopWatch();
        s.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if (m.contains(key)) {
                m.put(key, m.get(key) + 1);
                continue;
            }
            m.put(key, 1);
        }
        s.stop();
        m.printTree(m);
        System.out.println("time in minutes: " + s.getTime(TimeUnit.MINUTES));
        System.out.println("time in seconds: " + s.getTime(TimeUnit.SECONDS));
        System.out.println("time in milli seconds: " + s.getTime(TimeUnit.MILLISECONDS));
        System.out.println("time in micro seconds: " + s.getTime(TimeUnit.MICROSECONDS));
    }
}
