package assignment2algorithms;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

        FileReaderLogic l = new FileReaderLogic();
        l.readFile(textFileList);

        //int minlen = Integer.parseInt(args[0]);
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        //herrrr
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < textFileList.size(); i++) {
            String key = textFileList.get(i);
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
                continue;
            }
            st.put(key, 1);
        }
        sw.stop();
        System.out.println(st);
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println("hours: " + sw.getTime(TimeUnit.HOURS));
        System.out.println("minutes: " + sw.getTime(TimeUnit.MINUTES));
        System.out.println("seconds: " + sw.getTime(TimeUnit.SECONDS));
        System.out.println("milliseconds: " + sw.getTime(TimeUnit.MILLISECONDS));
        System.out.println("microseconds: " + sw.getTime(TimeUnit.MICROSECONDS));
        System.out.println("nanoseconds: " + sw.getTime(TimeUnit.NANOSECONDS));
    }
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
