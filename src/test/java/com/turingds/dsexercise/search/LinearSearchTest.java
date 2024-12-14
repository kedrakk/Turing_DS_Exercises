/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.turingds.dsexercise.search;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author kedk
 */
public class LinearSearchTest {

    LinearSearch lsAlgo = new LinearSearch();
    int[] input = {1, 2, 3, 4, 10, -1};

    @ParameterizedTest
    @CsvSource({"1,0", "120,-1", "-1,5", "2,1"})
    void testSearchWithParameterizedTest(int item, int expected) {
        int index = lsAlgo.search(input, item);
        assertEquals(expected, index);
    }

//    @Test
//    public void testSearch() {
//
//        int index = lsAlgo.search(input, 1);
//        assertEquals(0, index);
//    }
//
//    @Test
//    public void testUnhappySearch() {
//
//        int index = lsAlgo.search(input, 120);
//        assertEquals(-1, index);
//    }
//
//    @Test
//    public void testEdgeSearch() {
//
//        int index = lsAlgo.search(input, -1);
//        assertEquals(5, index);
//    }
}
