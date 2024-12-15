/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import java.util.Stack;

/**
 *
 * @author kedk
 */
class Reverser {

    public String reverse(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;

    }

}
