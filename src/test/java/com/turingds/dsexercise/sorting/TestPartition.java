/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

import com.turingds.dsexercise.util.Utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class TestPartition {

    QuickSort algo = new QuickSort();
    Utils utils = new Utils();

   // @Test
    public void testPartition() {
        int[] arr = {9, 8, 3, 7, 5, 6, 4, 1};
        int pivotIndex = algo.findPivot(arr);

        assertPivotIsCorrect(arr, pivotIndex);
    }

    private void assertPivotIsCorrect(int[] arr, int pivotIndex) {
        int pivot = arr[pivotIndex];
        System.out.println("Pivot Index: " + pivotIndex + " and pivot value: " + pivot);
        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] <= pivot);
        }
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
        System.out.println("Partitioned: " + utils.arrayToString(arr));
    }

    @Test
    public void testRandomPartition() {
        int[] arr = utils.generateRadomArray(20);
        System.out.println("Original: " + utils.arrayToString(arr));

        int pivotIndex = algo.findPivot(arr);
        System.out.println("Sorted: " + utils.arrayToString(arr));

        assertPivotIsCorrect(arr, pivotIndex);
    }

}
