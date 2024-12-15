/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class ReverseTest {
    
    Reverser reverser = new Reverser();

    @Test
    public void testEmpty() {
        String output = reverser.reverse("");
        assertEquals("", output);
    }

    @Test
    public void testSingle() {
        String output = reverser.reverse("a");
        assertEquals("a", output);
    }

    @Test
    public void testMultiple() {
        String output = reverser.reverse("car");
        assertEquals("rac", output);
        
        output = reverser.reverse("hello");
        assertEquals("olleh", output);
    }
}
