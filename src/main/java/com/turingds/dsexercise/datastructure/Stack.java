/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

/**
 *
 * @author kedk
 */
class Stack {

    int arr[];

    Stack(int size) {
        this.arr = new int[size];
    }

    int top = -1;

    public int size() {
        return top+1;
    }

    public void push(int i) {
        this.arr[++this.top] = i;
    }

    public int peek() {
        return this.arr[this.top];
    }

    public int pop() {
        return this.arr[this.top--];
    }
    
    public boolean isEmpty() {
        return this.top == -1;
    }

}
