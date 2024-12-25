/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure;

/**
 *
 * @author kedk
 */
public class CircularQueue extends Queue {

    public CircularQueue() {
        super();
    }

    @Override
    public void enque(int item) {
        int index = this.tail % this.items.length;
        this.items[index] = item;
        this.tail = index + 1;
    }

    @Override
    int dequeue() {
        int index = this.head % this.items.length;
        this.head = index + 1;
        return this.items[index];
    }
    
    @Override
    public int size() {
        return this.tail - this.head;
    }
}
