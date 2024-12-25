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

    Stack<Character> startTags = new Stack();
    Stack<Character> endTags = new Stack();

    public Delimiter() {
        startTags.add('[');
        startTags.add('{');
        startTags.add('(');

        endTags.add(']');
        endTags.add('}');
        endTags.add(')');
    }

    public boolean isValid(String string) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if (isCharInStartTags(ch)) {
                stack.push(ch);
            } else if (isCharInEndTags(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!checkIsBalanced(stack, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean checkIsBalanced(Stack<Character> stack, Character ch) {
        Character topElement = stack.pop();
        int endTagIndex = endTags.indexOf(ch);
        int startTagIndex = startTags.indexOf(topElement);
        if (endTagIndex != startTagIndex) {
            return false;
        }
        return true;
    }

    private boolean isCharInEndTags(Character ch) {
        return endTags.contains(ch);
    }

    private boolean isCharInStartTags(Character ch) {
        return startTags.contains(ch);
    }

}
