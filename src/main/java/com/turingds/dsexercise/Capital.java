/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise;

/**
 *
 * @author kedk
 */
public class Capital {

    public String toCapital(String input) {
        if (input == null || "".equals(input)) {
            return "";
        } else {
            String words[] = input.split(" ");
            String result = "";
            for (String word : words) {
                result += ">>" + capitalForWord(word);
            }
            return result.replaceAll(">>", " ").trim();
        }
    }

    private String capitalForWord(String input) {
        String word = (input.charAt(0) + "").toUpperCase() + input.substring(1);
        return word;
    }

}
