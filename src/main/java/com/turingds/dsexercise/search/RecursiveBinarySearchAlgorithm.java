/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.search;

/**
 *
 * @author kedk
 */
public class RecursiveBinarySearchAlgorithm {

    public RecursiveBinarySearchAlgorithm() {
    }

    public int search(int[] input, int item, int left, int right) {
        if (left > right) {
            return -1;
        } else {
            int middle = (left + right) / 2;
            if (input[middle] == item) {
                return middle;
            } else {
                if (input[middle] < item) {
                    return search(input, item, middle + 1, right);
                } else {
                    return search(input, item, left, middle - 1);
                }
            }
        }
    }

}
