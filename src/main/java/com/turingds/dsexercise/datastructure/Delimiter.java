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
class Delimiter {

    public boolean isValid(String string) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[') {
                stack.push(string.charAt(i));
            } else if (string.charAt(i) == ']') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
