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

    int size = 0;

    public CircularQueue() {
        super();
    }

    @Override
    public void enque(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            int index = this.tail % this.items.length;
            this.items[index] = item;
            this.tail = index + 1;
            this.size++;
        }
    }

    @Override
    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            int index = this.head % this.items.length;
            this.head = index + 1;
            this.size--;
            return this.items[index];
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isFull() {
        return this.size == this.items.length;
    }

    @Override
    public int size() {
        return this.size;
    }
}
