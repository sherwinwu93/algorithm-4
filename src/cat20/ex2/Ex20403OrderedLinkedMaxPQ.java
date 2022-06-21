package cat20.ex2;

import java.util.LinkedList;

/**
 * Created by Wusd on 2022/6/21.
 **/
public class Ex20403OrderedLinkedMaxPQ<Key extends Comparable> implements Ex20403MaxPQ<Key>  {
    private LinkedList<Key> pq;

    public Ex20403OrderedLinkedMaxPQ(int maxN) {
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    @Override
    public int size() {
        return pq.size();
    }

    @Override
    public void insert(Key v) {
        pq.addLast(v);
        for (int i = pq.size() - 1; i > 0 && less(i, i-1); i--)
            exch(i, i-1);
    }
    private boolean less(int i, int j){
        return pq.get(i).compareTo(pq.get(j)) < 0;
    }
    private void exch(int i, int j) {

    }

    @Override
    public Key delMax() {
        return pq.removeLast();
    }
}
