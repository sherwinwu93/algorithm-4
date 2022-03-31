package cat10.ex3;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex10339RingBuffer<Item> {
    public static void main(String[] args) {
        Ex10339RingBuffer<Integer> buffer = new Ex10339RingBuffer<Integer>(2);
        consumeTest(buffer);
    }
    public static void consumeTest(Ex10339RingBuffer<Integer> buffer) {
        buffer.produce(1);
        buffer.produce(2);
        buffer.consume();
        buffer.produce(3);
        buffer.produce(4);
        buffer.produce(5);
        buffer.produce(6);
        buffer.consume();
        StdOut.println();
    }
    private Item[] ringBuffer;
    private int head;
    private int tail;
    private int N;

    private int consumedCnt;
    private P095Queue<Item> freeze = new P095Queue<Item>();

    public Ex10339RingBuffer(int cap) {
        ringBuffer = (Item[]) new Object[cap];
    }

    public void produce(Item item) {
        if (consumedCnt > 0) {
            consumeDate(item);
            consumedCnt--;
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
