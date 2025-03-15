/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.hashing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class HashTableTest {

    @Test
    public void testHashingWord() {
        HashTable ht = new HashTable();

        int hashed = HashTable.hash("hello", 10);
        assertEquals(2, hashed);

        ht.insert("hello");
        assertEquals(true, ht.contains("hello"));
    }
}
