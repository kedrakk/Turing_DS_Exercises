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
public class PostfixConverterTest {

    PostfixConverter postfixConverter = new PostfixConverter();

//    @Test
//    public void testBaseCase() {
//        assertEquals("ab+", postfixConverter.convert("a+b"));
//        assertEquals("ab-", postfixConverter.convert("a-b"));
//    }
//
//    @Test
//    public void testWithTwoOperators() {
//        assertEquals("ab+c-", postfixConverter.convert("a+b-c"));
//    }
//
//    @Test
//    public void testDiffPrecedence() {
//        assertEquals("ab*c+", postfixConverter.convert("a*b+c"));
//        assertEquals("abc*+", postfixConverter.convert("a+b*c"));
//        assertEquals("ab*cd*+", postfixConverter.convert("a*b+c*d"));
//        assertEquals("ab/cd*+", postfixConverter.convert("a/b+c*d"));
//    }
    
    @Test
    public void testParenthesis() {
        assertEquals("ab+c*", postfixConverter.convert("(a+b)*c"));
    }

}
