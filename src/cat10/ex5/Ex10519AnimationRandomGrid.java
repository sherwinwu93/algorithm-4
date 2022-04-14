package cat10.ex5;

import cat10.ex3.Ex10334RandomBag;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Ex10519AnimationRandomGrid {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        drawGrid(N);
        Connection[] a = generate(N);
        for (Connection c : a) {
            StdOut.println(c.p + " " + c.q);;
            drawConnection(c);
        }
    }
    public static void drawGrid(int N) {
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.setPenRadius(.001);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
    }
    public static void drawConnection(Connection c) {
        StdDraw.setPenColor(Color.WHITE);
        int i = c.p;
        int j = c.q;
        StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Connection[] generate(int N) {
        Ex10334RandomBag<Connection> bag = new Ex10334RandomBag<Connection>();
        for (int i = 0; i < N;i++)
            for (int j = 0; j < N; j++)
                if (i != j) bag.add(new Connection(i, j));
        Connection[] connections = new Connection[bag.size()];
        int i =0;
        for (Connection c: bag)
            connections[i++] = c;
        return connections;
    }
    private static class Connection {
        int p;
        int q;
        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
