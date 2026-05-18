package ch04;

/**
 * CC: Connected component
 */
public abstract class CCAPI {
    // preprocessing constructor
    public CCAPI() {}
    // are v and w connected?
    abstract boolean connected(int v, int w);
    // number of connected components
    abstract int count();
    // component identifier for v
    //  0 through count()-1
    abstract int id(int v);
}