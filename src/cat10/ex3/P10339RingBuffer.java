package cat10.ex3;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class P10339RingBuffer<Item> {
    private Item[] ringBuffer;
    private int head;
    private int tail;
    private int N;

    private int consumedCnt;
    private P095Queue<Item> freeze = new P095Queue<Item>();

    public P10339RingBuffer(int cap) {
        ringBuffer = (Item[]) new Object[cap];
    }

    public void produce(Item item) {
        if (consumedCnt > 0) {
            consumeDate(item);
        } else if (isFull()) {
            freeze.enqueue(item);
        } else {
            ringBuffer[tail] = item;
            N++;
            nextTail();
        }
    }

    private void nextTail() {
        if (tail == ringBuffer.length - 1) tail = 0;
        else tail++;
    }

    private void nextHead() {
        if (head == ringBuffer.length - 1) head = 0;
        else head++;
    }

    private void consumeDate(Item item) {
        consumedCnt--;
        StdOut.println(item);
    }

    public void consume() {
        if (isEmpty()) consumedCnt++;
        else {
            Item item = ringBuffer[head];
            nextHead();
            consumeDate(item);
            fill();
        }
    }

    private void fill() {
        while (!isFull() && freeze.isEmpty())
            ringBuffer[tail] = freeze.dequeue();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == ringBuffer.length;
    }
}
