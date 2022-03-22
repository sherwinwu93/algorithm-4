package cat10;

import edu.princeton.cs.algs4.StdDraw;

public class P026StdDrawTest {
    public static void main(String[] args) {
//        testLine();
//        testPoint();
//        testText();
//        testCircle();
//        testFilledCircle();
//        testEllipse();
//        testSquare();
//        testFilledSquare();
        testRectangle();
//        testPolygon();
    }
    private static void testPolygon() {
        double[] x = {.3, .8, .7, .4};
        double[] y = {.7, .5, .2, .3};
        StdDraw.polygon(x, y);
    }
    private static void testRectangle() {
        StdDraw.rectangle(.5, .5, .3, .1);
    }
    private static void testFilledSquare() {
        StdDraw.filledSquare(.5, .5, .3);
    }
    private static void  testSquare() {
        StdDraw.square(.5, .5, .3);
    }
    private static void testEllipse() {
        StdDraw.ellipse(.5, .5, .3, .1);
    }
    private static void testFilledCircle() {
        StdDraw.filledCircle(.5, .5, .5);
    }
    private static void testCircle() {
        StdDraw.circle(.5, .5, .5);
    }
    private static void testText() {
        StdDraw.text(.5,.5, "wusd");
    }
    private static void testPoint() {
        StdDraw.point(.5, .5);
    }
    private static void testLine() {
        StdDraw.line(0, 0, 1.0 , 1.0);
    }
}
