package cat10.ex5;

import cat10.ex3.Ex10334RandomBag;
import edu.princeton.cs.algs4.StdOut;

public class Ex10518RandomGrid {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Connection[] a = generate(N);
        for (Connection c: a)
            StdOut.println(c.p + " " + c.q);
    }
    public static Connection[] generate(int N) {
        Ex10334RandomBag<Connection> bag = new Ex10334RandomBag<Connection>();
        for (int i = 0; i < N;i++)
            for (int j = 0; j < N; j++)
                bag.add(new Connection(i, j));
        Connection[] connections = new Connection[bag.size()];
        int i =0;
        for (Connection c: bag)
            connections[i++] = c;
        return connections;
    }
    public static class Connection {
        int p;
        int q;
        private Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
