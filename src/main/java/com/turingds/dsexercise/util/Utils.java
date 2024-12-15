/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.util;

import java.util.Random;

/**
 *
 * @author kedk
 */
public class Utils {

    public boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] generateRadomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(400);
        }
        return arr;
    }
    
    public String arrayToString(int[] arr){
        StringBuffer stringbuffer=new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringbuffer.append(", ").append(arr[i]);
        }
        return stringbuffer.toString();
    }

}
