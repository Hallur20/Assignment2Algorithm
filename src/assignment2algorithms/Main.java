package assignment2algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

        HashedSymbolTable<String, Integer> h = new HashedSymbolTable<>(splitted.length);
        for (int i = 0; i < splitted.length; i++) {
            String key = splitted[i];
            if(h.contains(key)){
                h.put(key, h.get(key)+1);
                continue;
            }
            h.put(key, 1);
        }
        h.printHashMap(h);


    /*
    linked symbol table is... scans the hashmap if the key is already in use, if it is then replace with new value,
    do not continue scanning if key has been found.
    
    array symbol table is... (and what is flexible array) scan hashmap alphabeticaly where to put the key,
    if same key but diffirent value just replace value (key is still at same index).
    
    hashed symbol table is... hash value is the position in the hash table, while the keys should be unique in the hash position.
    
    balanced tree symbol table is...
    
    
     */
}}
