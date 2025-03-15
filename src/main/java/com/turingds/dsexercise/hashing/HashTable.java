/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.hashing;

/**
 *
 * @author kedk
 */
public class HashTable {

    String[] data = new String[10];

    public HashTable() {}

    public void insert(String word) {
        int hasedWordIndex = HashTable.hash(word, 10);
        data[hasedWordIndex] = word;
    }

    public Boolean contains(String word) {
        int hashedIndex = HashTable.hash(word, 10);
        return data[hashedIndex] != null;
    }

    public static int hash(String word, int bucketSize) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            total += word.codePointAt(i);
        }
        return total % bucketSize;
    }
}
