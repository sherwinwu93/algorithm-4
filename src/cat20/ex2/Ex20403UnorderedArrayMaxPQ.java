package cat20.ex2;

/**
 * Created by Wusd on 2022/6/21.
 * 无序数组实现的优先队列
 **/
public class Ex20403UnorderedArrayMaxPQ<Key extends Comparable> implements Ex20403MaxPQ<Key>  {
    private Key[] pq;
    private int N;

    public Ex20403UnorderedArrayMaxPQ(int maxN) {
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
    }

    @Override
    public Key delMax() {
        int max = N - 1;
        for (int i = 0; i < N; i++)
            if (less(max, i)) max = i;
        Key item = pq[max];
        exch(max, N-1);
        pq[N--] = null;
        return item;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
