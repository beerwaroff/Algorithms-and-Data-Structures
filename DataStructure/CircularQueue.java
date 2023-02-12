package org.beerwaroff.DataStructure;

public class CircularQueue {
    private final int[] data;
    private int head;
    private int tail;
    private final int size;

    public CircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    public boolean enQueue(int value) {
        if (isFull()) return false;
        else {
            if (isEmpty()) head = 0;
            tail = (tail + 1) % size;
            data[tail] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        else {
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % size;
            }
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) return -1;
        else return data[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        else return data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
