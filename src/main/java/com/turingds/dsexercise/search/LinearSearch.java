/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.search;

/**
 *
 * @author kedk
 */
public class LinearSearch {

    public int search(int[] input, int num) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
