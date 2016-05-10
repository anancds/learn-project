package com.cds.jdk.learn.stringlearn;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest<E> {
    private int size;
    private int capacity;
    private int head;
    private int tail;
    private Object[] elementData;

    public ArrayBlockingQueueTest(int capacity) {
        elementData = new Object[capacity];
        head = -1;
        tail = -1;
        size = 0;
        this.capacity = capacity;
    }

    public boolean put(E element) {
        if (size == capacity) {
            return false;
        }
        if (head == -1 && tail == -1) {
            elementData[0] = element;
            head = 0;
            tail = 0;
        } else {
            int next = ((tail + 1) >= capacity) ? (tail + 1 - capacity)
                    : (tail + 1);
            elementData[next] = element;
            tail = next;
        }
        size++;
        return true;
    }

    public E take() {
        if (size == 0) {
            return null;
        }

        E element = (E) elementData[head];
        elementData[head] = null;
        size--;
        if (size == 0) {
            head = -1;
            tail = -1;
        } else {
            int next = ((head + 1) >= capacity) ? (head + 1 - capacity)
                    : (head + 1);
            head = next;
        }

        return element;
    }

    public E update(E newelement) {
        E oldelement = null;
        if (size >= capacity) {
            oldelement = take();
        }
        put(newelement);
        return oldelement;
    }

    public int size() {
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Object o : elementData)
            sb.append(" "+o);
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayBlockingQueueTest<String> queue = new ArrayBlockingQueueTest<String>(10);
        ArrayBlockingQueue queue1 = new ArrayBlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.update(String.valueOf(i)));
            System.out.println(queue.tail);
            System.out.println(queue.head);
//            System.out.println(queue.size);

            System.out.println(queue);

        }
        queue.take();
        queue.take();
        System.out.println(queue);
        queue.update(String.valueOf(0));
        System.out.println(queue);
        System.out.println(queue.tail);
        System.out.println(queue.head);
    }
}
