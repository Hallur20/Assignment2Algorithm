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
import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.Objects;

public class ArraySymbolTable<Key>  {
    private static final int INIT_SIZE = 8;

    private Key[] keys;     // symbol table keys
    private Integer[] vals;   // symbol table values
    private int n = 0;      // number of elements in symbol table

    public ArraySymbolTable() {
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Integer[]) new Integer[INIT_SIZE];

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public String getAll() {
        for (int i = 0; i < keys.length-1; i++)
            System.out.println(keys[i].toString() + ":" + vals[i]);

        return "Done";
    }


    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Integer[] tempv = (Integer[]) new Integer[capacity];
        for (int i = 0; i < n; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }

    public void remove(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                return;
            }
        }
    }

    public int rank(String key)
    {
        int lo = 0, hi = n-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(String.valueOf(keys[mid]));
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key)  {
        int val = 1;
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == 0) {
            remove(key);
            return;
        }

        int i = rank(String.valueOf(key));

        // key is already in table
        if (i < n && String.valueOf(keys[i]).compareTo(String.valueOf(key)) == 0) {
            vals[i] = val+1;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) resize(2*keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

    }

}

