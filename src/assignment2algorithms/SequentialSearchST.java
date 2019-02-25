package assignment2algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author MoK
 * @param <Key>
 * @param <Value>
 */
//Linked symbol table
public class SequentialSearchST<Key, Value> {

    private Node first;
    private int n;

    private class Node {

        private Value value;
        private Key key;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.add(x.key);
        }
        return queue;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public Value remove(Key key) {
        // special cases
        if (first == null) {
            return null;
        }

        if (key.equals(first.key)) {
            Value val = first.value;
            first = first.next;
            n--;
            return val;
        }

        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                Value val = x.next.value;
                x.next = x.next.next;
                n--;
                return val;
            }
        }
        return null;
    }

    public int size() {
        return n;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

}
