/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author kedk
 */
public class RecursiveBinarySearchTest {

    RecursiveBinarySearchAlgorithm lsAlgo = new RecursiveBinarySearchAlgorithm();
    int[] input = {1, 4, 6, 13, 21, 50};

    @ParameterizedTest
    @CsvSource({"11,-1", "6,2", "4,1", "21,4", "50,5", "5,-1", "0,-1", "100,-1"})
    void testSearchWithParameterizedTest(int item, int expected) {
        int index = lsAlgo.search(input, item, 0, input.length - 1);
        assertEquals(expected, index);
    }
}
