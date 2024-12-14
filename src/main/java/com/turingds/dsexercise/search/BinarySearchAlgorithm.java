/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.search;

import com.turingds.dsexercise.searching.SearchAlgorithm;

/**
 *
 * @author kedk
 */
public class BinarySearchAlgorithm implements SearchAlgorithm {

    public BinarySearchAlgorithm() {
    }

    @Override
    public int search(int[] arr, int item) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == item) {
                return middle;
            } else if (arr[middle] > item) {
                end = middle - 1;
            } else if (arr[middle] < item) {
                start = start + 1;
            }
        }
        return -1;
    }

}
