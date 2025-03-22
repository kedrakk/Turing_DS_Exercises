/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.hashing;

import java.util.LinkedList;

/**
 *
 * @author kedk
 */
public class HashTable {

    LinkedList[] data = new LinkedList[10];

    public HashTable() {
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList();
        }
    }

    public void insert(String word) {
        int hashedIndex = HashTable.hash(word, 10);
        LinkedList linkedList = data[hashedIndex];
        linkedList.add(word);
    }

    public Boolean contains(String word) {
        int hashedIndex = HashTable.hash(word, 10);
        LinkedList linkedList = data[hashedIndex];
        return linkedList.contains(word);
    }

    public static int hash(String word, int bucketSize) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            total += word.codePointAt(i);
        }
        return total % bucketSize;
    }
}
