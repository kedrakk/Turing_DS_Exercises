/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author kedk
 */
class PostfixConverter {

    HashMap<Character, Integer> precendences = new HashMap<>();

    public PostfixConverter() {
        this.precendences.put('+', 1);
        this.precendences.put('-', 1);

        this.precendences.put('*', 2);
        this.precendences.put('/', 2);
    }

    //check if first operator is higher or equal to the second operator
    private Boolean isHigherOrEqualOperator(char firstOp, char secondOp) {
        return this.precendences.get(firstOp) >= this.precendences.get(secondOp);
    }

    private Boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private Boolean isParenthesis(char ch) {
        return ch == '(' || ch == ')';
    }

    private Boolean isOperand(char ch) {
        return !(this.isOperator(ch)) && !(this.isParenthesis(ch));
    }

    public String convert(String ab) {
        Stack<Character> operators = new Stack<>();
        String result = "";

        for (int i = 0; i < ab.length(); i++) {
            char currentChar = ab.charAt(i);
            if (this.isOperand(currentChar)) {
                result += currentChar;
            } else if (currentChar == '(') {
                operators.push(currentChar);
            } else if (currentChar == ')') {
                while (!(operators.isEmpty()) && operators.peek() != '(') {
                    result += operators.pop();
                }
                if (!operators.isEmpty()) {
                    System.out.println(currentChar);
                    operators.pop();
                }
            } else if (this.isOperator(currentChar)) {
                if (operators.isEmpty()) {
                    operators.push(currentChar);
                } else {
                    //pop all higher or equal operators and add to result
                    while (!(operators.isEmpty()) && this.isHigherOrEqualOperator(operators.peek(), currentChar)) {
                        result += operators.pop();
                    }
                    operators.push(currentChar);
                }
            }
        }
        while (!operators.isEmpty()) {
            result += operators.pop();
        }
        return result;
    }

}
