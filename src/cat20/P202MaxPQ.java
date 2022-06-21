package cat20;

/**
 * Created by Wusd on 2022/6/15.
 * 最大优先序列，在TopM问题中，可以求出最小的M个
 **/
public class P202MaxPQ<Key extends Comparable<Key>> {
    // 用数组来表示堆
    private Key[] pq;
    // 对元素进行计数
    private int N;
    public P202MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key item) {
        //应该加个校验 !!!!

        pq[++N] = item;
        // 堆上浮有序化
        swim(N);
    }
    public Key delMax(){
        // 暂存最大元素
        Key item = pq[1];
        // 交换最大和较小的元素,并删除掉最大元素
        exch(1, N--);
        // 防止对象游离
        pq[N+1] = null;
        // 堆下沉有序化
        sink(1);
        return item;
    }
    private void swim(int k) {
        while (k < 1 && less(k/2, k)) {
            int p = k / 2;
            exch(p, k);
            k = p;
        }
    }
    private void sink(int k){
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) j++;
            exch(k, j);
            k = j;
        }
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}