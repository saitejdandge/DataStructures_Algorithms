package hash;

import linked_list.implemenation.LinkedList;

import java.util.Iterator;

public class Hash<K, V> implements IHash<K> {

    int numElements;
    int tableSize;
    double maxLoadFactor;

    LinkedList<HashElement>[] array;

    Hash(int tableSize) {

        this.numElements = 0;
        this.tableSize = tableSize;

        array = (LinkedList<HashElement>[]) new Object[tableSize];
        maxLoadFactor = 0.75;

        for (int i = 0; i < array.length; i++)
            array[i] = new LinkedList<>();

    }

    public boolean add(K key, V value) {

        if (loadFactor() > this.maxLoadFactor)
            resize(2 * tableSize);

        HashElement element = new HashElement(key, value);

        int hashVal = key.hashCode();
        hashVal = hashVal & 0X7FFFFFFF;
        hashVal %= tableSize;
        array[hashVal].addFirst(element);
        numElements++;

        return true;
    }

    public V getValue(K key) {
        int hashVal = key.hashCode();
        hashVal = hashVal & 0X7FFFFFFF;
        hashVal %= tableSize;
        for (HashElement he : array[hashVal]) {
            if (((Comparable<K>) key).compareTo(he.key) == 0)
                return he.value;

        }

        return null;
    }

    private double loadFactor() {
        return numElements * 1.0 / tableSize;
    }

    private void resize(int newSize) {

        LinkedList<HashElement>[] newArray = (LinkedList<HashElement>[]) new Object[newSize];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new LinkedList<>();
        }

        // iterable that returns keys array
        for (K key : this) {
            V val = getValue(key);
            HashElement element = new HashElement(key, val);
            int hashVal = (key.hashCode() & 0X7FFFFFFF) % newArray.length;
            newArray[hashVal].addFirst(element);
        }
        array = newArray;
        tableSize = newSize;

    }

    @Override
    public Iterator<K> iterator() {
        return new IteratorHelper<>();
    }

    class HashElement implements Comparable<HashElement> {

        K key;
        V value;

        HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement o) {
            return ((Comparable<K>) o.key).compareTo(this.key);
        }

    }

    private class IteratorHelper<T> implements Iterator<T> {

        T[] keys;
        int position;

        public IteratorHelper() {
            keys = (T[]) new Object[numElements];
            int p = 0;
            position = 0;
            for (int i = 0; i < tableSize; i++) {
                LinkedList<HashElement> list = array[i];
                for (HashElement element : list) {
                    keys[p++] = (T) element.key;
                }
            }

        }

        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if (!hasNext())
                return null;
            else
                return keys[position++];

        }

    }

}