package cat20.ex2;

/**
 * Created by Wusd on 2022/6/21.
 **/
public class Ex20403OrderedArrayMaxPQ<Key extends Comparable> implements Ex20403MaxPQ<Key> {
    private Key[] pq;
    private int N;

    public Ex20403OrderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void insert(Key v) {
        pq[N++] = v;
        // 上浮有序化
        for (int i = N - 1; i > 0 && less(i, i - 1); i--)
            exch(i, i - 1);
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    @Override
    public Key delMax() {
        Key v = pq[--N];
        pq[N] = null;
        return v;
    }
}
