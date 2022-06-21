package cat20.ex2;

/**
 * Created by Wusd on 2022/6/21.
 **/
public interface Ex20403MaxPQ<Key extends Comparable> {
        boolean isEmpty();
        int size();
        void insert(Key v);
        Key delMax();
}
