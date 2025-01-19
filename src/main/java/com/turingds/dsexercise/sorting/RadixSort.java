/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

/**
 *
 * @author kedk
 */
class RadixSort {

    public int getDigitlength(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return String.valueOf(max).length();
    }

    public int[] sort(int[] arr) {
        return arr;
    }

}
