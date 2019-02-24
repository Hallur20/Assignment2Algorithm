/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2algorithms;

import java.util.ArrayList;

/**
 *
 * @author Hallur
 */
public class ArraySymbolTable {

    private ArrayList<String> keys = new ArrayList<>();
    private ArrayList<Integer> values = new ArrayList<>();
    private int N;

    public ArraySymbolTable(int N) {
        this.N = N;
    }

    
    
    public String returnAll()
    {
        for (int i = 0; i < keys.size(); i++) {

            return keys.get((i)).toString() + " : " + values.get(i);
        }

        return "Done";
    }


    public int rank(String key)
    {
        int lo = 0, hi = N-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys.get(mid));
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(String key)
    {        int i = rank(key);
    int val = 1;
        if (i < N && keys.get(i).compareTo(key) == 0)
        { values.set(i, val);
        return;
        }

        for (int j = N; j > i; j--)
        {
            keys.set(j, keys.get(j-1));
        values.set(j, values.get(j-1));

        }
        keys.set(i, key);

        values.set(i, values.get(i)+val);
        N++;
    }
}
