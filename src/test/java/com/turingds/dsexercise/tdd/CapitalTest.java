/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.tdd;

import com.turingds.dsexercise.Capital;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class CapitalTest {

    @Test
    public void testEmpty() {
        Capital cap = new Capital();
        String output = cap.toCapital("");

        assertEquals("", output);
    }

    @Test
    public void testNull() {
        Capital cap = new Capital();
        String output = cap.toCapital(null);

        assertEquals("", output);
    }

    @Test
    public void testSingleWord() {
        Capital cap = new Capital();
        String output = cap.toCapital("apple");

        assertEquals("Apple", output);
    }

    @Test
    public void testMultipleWord() {
        Capital cap = new Capital();
        String output = cap.toCapital("apple orange");

        assertEquals("Apple Orange", output);
    }
}
