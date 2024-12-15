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
public class DelimiterTest {
    
    Delimiter delimiter = new Delimiter();

    @Test
    public void testEmpty() {
        boolean valid = delimiter.isValid("");
        assertTrue(valid);
    }
    
    @Test
    public void testBracket() {
        boolean valid = delimiter.isValid("c[d]");
        assertTrue(valid);
    }
    
    @Test
    public void testBracketNegative() {
        boolean valid = delimiter.isValid("c[d");
        assertFalse(valid);
    }
    
    @Test
    public void testCurlyBracket() {
        boolean valid = delimiter.isValid("a{bc}d");
        assertTrue(valid);
    }
    
    @Test
    public void testCurlyBracketNegative() {
        boolean valid = delimiter.isValid("a{bcd");
        assertFalse(valid);
    }
}
