/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

/**
 *
 * @author kedk
 */
class Queue {

    int[] items;
    int head = 0;
    int tail = 0;

    public Queue() {
        items = new int[10];
    }

    public void enque(int item) {
        if (this.tail < this.items.length) {
            this.items[this.tail++] = item;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    public int size() {
        return this.tail - this.head;
    }

    public int peek() {
        return this.items[this.head];
    }

    int dequeue() {
        if (this.head < this.items.length && this.head < this.tail) {
            return this.items[this.head++];
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }
}
