package ch04;

import edu.princeton.cs.algs4.In;

/**
 * 图的表达:
 *  点数
 *  线数
 *  某个的点所有相邻点
 *  增加从v-w的线
 *  图的string格式
 */
public abstract class GraphAPI {
    // create a V-Vertex graph with no edges
    public GraphAPI(int V) {}
    // read a graph from input stream in
    public GraphAPI(In in) {}
    // number of vertices
    public abstract int V();
    // number of edges
    public abstract int E();
    // add edge v-w to this graph
    public abstract void addEdge(int v, int w);
    // vertices adjacent to v
    public abstract Iterable<Integer> adj(int v);
    // string representation
    public abstract String toString();
}
