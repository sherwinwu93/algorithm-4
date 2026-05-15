package ch04;

/**
 * Search: 搜索
 *  图和起始点s
 *      1. 任意点v是否与s相通
 *      2. 多少个点与s相通
 */
public abstract class SearchAPI {
    // find vertices connected to a source vetex s
    public SearchAPI(GraphAPI G, int s){}
    // is v connected to s?
    abstract boolean marked(int v);
    // how many vertices are connected to s?
    abstract int count();
}
