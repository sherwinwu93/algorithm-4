package ch04;

/**
 * 搜索路径
 *  给定图G和起始点s
 *      对任意v,确实是否有路径s到v?
 *      对任意v,找出一条路径
 */
public abstract class PathsAPI {
    // find paths in G from source s
    public PathsAPI(Graph G, int s) {}
    // is there a path from s to v?
    abstract boolean hasPathTo(int v);
    // path from s to v, null if no such path
    abstract Iterable<Integer> pathTo(int v);
}
