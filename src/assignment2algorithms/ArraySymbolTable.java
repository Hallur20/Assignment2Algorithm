/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2algorithms;

/**
 *
 * @author Hallur
 */
public class ArraySymbolTable {

    private String[] keys;
    private int[] values;
    private int N;


    public ArraySymbolTable(int capacity) {
       keys = (String[]) new Comparable[capacity];
       values = (int[]) new int[capacity];
    }


    public String returnAll()
    {
        for (int i = 0; i < keys.length; i++) {

            return keys[i].toString() + " : " + values[i];
        }

        return "Done";
    }


    public int rank(String key)
    {
        int lo = 0, hi = N-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(String key)
    {        int i = rank(key);
    int val = 1;
        if (i < N && keys[i].compareTo(key) == 0)
        { values[i] = val;
        return;
        }

        for (int j = N; j > i; j--)
        {
            keys[j] = keys[j-1];
        values[j] = values[j-1];

        }
        keys[i] = key;

        values[i] = values[i] + val;
        N++;
    }
}
