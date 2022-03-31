package cat10.ex3;

import cat10.P095Queue;

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
    }
    public Item consume() {

    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull() {
        return N == ringBuffer.length;
    }
}
