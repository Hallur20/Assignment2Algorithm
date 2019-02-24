package assignment2algorithms;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> textFileList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        FileReaderLogic l = new FileReaderLogic();
        l.readFile(textFileList);
       /* for (int i = 0; i < textFileList.size(); i++) {
            System.out.println(textFileList.get(i));
        }*/
       BalancedTreeTable<String, Integer> treeT = new BalancedTreeTable<>();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if(!treeT.contains(key)){
                treeT.put(key, 1);
                continue;
            }
            treeT.put(key, treeT.get(key) +1);
        }
        treeT.printTree(treeT);
    }
    
    /*
    linked symbol table is... scans the hashmap if the key is already in use, if it is then replace with new value,
    do not continue scanning if key has been found.
    
    array symbol table is... (and what is flexible array) scan hashmap alphabeticaly where to put the key,
    if same key but diffirent value just replace value (key is still at same index).
    
    hashed symbol table is... hash value is the position in the hash table, while the keys should be unique in the hash position.
    
    balanced tree symbol table is...
    
    
    */
}
