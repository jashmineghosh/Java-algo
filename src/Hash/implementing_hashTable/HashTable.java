package Hash.implementing_hashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    // create an array that will hold elements of type ArrayList<KeyValue>.
    // ArrayList<keyValue> means the ArrayList holds Objects of type - keyValue as its elements.
    ArrayList<KeyValue>[] data;
    int currentLength;

    public HashTable(int size) {
        data = new ArrayList[size];
        currentLength = 0;
    }

    private int _hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % data.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int address = _hash(key);
        if (data[address] == null) {
            ArrayList<KeyValue> arrayAtAddress = new ArrayList<>();
            data[address] = arrayAtAddress;
//            currentLength++;
        }
        KeyValue pair = new KeyValue(key, value);
        data[address].add(pair);
    }

    public Integer get(String key) {
        int address = _hash(key);
        ArrayList<KeyValue> bucket = data[address];
        if (bucket != null) {
            for (KeyValue keyValue : bucket) {
                if (keyValue.getKey().equals(key)) {
                    return keyValue.getValue();
                }
            }
        }
        return null; // return null when key does not exist.
    }

//    public String[] keys1() {
//        ArrayList<KeyValue>[] bucket = data;
//        String[] keysArray = new String[currentLength];
//        int count = 0;
//        for (ArrayList<KeyValue> keyValues : bucket) {
//            if (keyValues != null) {
//                for (int i = 0; i < keyValues.size(); i++) {
//                    keysArray[count] = keyValues.get(i).getKey();
//                    count++;
//                }
//
//            }
//        }
//        return keysArray;
//    }
    public String[] keys(){ // this code handles if there are duplicate keys
        ArrayList<KeyValue> strings;
        ArrayList<String> result = new ArrayList<>();
        if(data != null){
            for(int j=0;j< data.length;j++) {
                if (data[j] != null) {
                    strings = data[j];
                        for (int i = 0; i < strings.size(); i++) {
                            result.add(strings.get(i).getKey());
                        }
                }
            }
        }
        return result.toArray(new String[0]);
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable(50);
        hashTable.set("grapes", 1200);
        hashTable.set("grapes", 2200);
        hashTable.set("avacadoes", 2000);
        hashTable.set("apple", 1500);
        System.out.println("value for key grapes: " + hashTable.get("grapes"));
        System.out.println("value for key apple: " + hashTable.get("apple"));
        System.out.println("value for key apple: " + hashTable.get("avacadoes"));
        System.out.println("list of keys: " + Arrays.toString(hashTable.keys()));
//        System.out.println("list of keys1: " + Arrays.toString(hashTable.keys1()));
    }
}
