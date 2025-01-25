/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.sorting;

import java.util.ArrayList;

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
        int digitLen = this.getDigitlength(arr);
        for (int i = 0; i < digitLen; i++) {

            //Initializing 10 buckets for each digit index
            var items = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < MAX_DIGIT; j++) {
                items.add(new ArrayList<>());
            }

            //Collect digit into a bucket
            for (int j = 0; j < arr.length; j++) {
                int index = this.getDitiAtIndex(arr[j], i);
                items.get(index).add(arr[j]);
            }

            //Organize all array lists into a single array list
            ArrayList<Integer> allItems = new ArrayList<>();
            for (int j = 0; j < MAX_DIGIT; j++) {
                ArrayList currentItem = items.get(j);
                allItems.addAll(currentItem);
            }

            //Copy back into an array
            for (int j = 0; j < arr.length; j++) {
                int itemInArrayList = allItems.get(j);
                arr[j] = itemInArrayList;
            }

        }
        return arr;
    }
    private static final int MAX_DIGIT = 10;

    public int getDitiAtIndex(int num, int index) {
        String str = String.valueOf(num);
        if (index <= str.length() - 1) {
            int indexToGet = str.length() - (index + 1);
            char ch = str.charAt(indexToGet);
            return Integer.parseInt("" + ch);
        } else {
            return 0;
        }
    }

}
