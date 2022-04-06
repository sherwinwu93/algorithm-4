package cat10.ex4;

public class Ex10419MinInMatrix {
    public static void main(String[] args) {

    }
    public static double minInSome(double[][] a) {
        int xlo = 0;
        int xhi = a.length;
        int ylo = 0;
        int yhi = a[0].length;
        while (xlo <= xhi && ylo <= yhi) {
            int xmid = xlo + (xhi - xlo) / 2;
            int ymid = ylo + (yhi - ylo) / 2;
            double z1 = a[xmid][ymid - 1];
            double z2 = a[xmid-1][ymid];
            double z3 = a[xmid][ymid + 1];
            double z4 = a[xmid + 1][ymid];
            double o = a[xmid][ymid];
            if (o < z1 && o < z2 && o < z3 && o < z4) return o;
            else if (z1 <= o && z2 <= o) {
                xhi = xmid - 1;
                yhi = ymid - 1;
            } else if (z1 <= o && z4 <= o) {
                xlo = xmid + 1;
                yhi = ymid - 1;
            } else if (z4 <= o && z3 <= o) {
                xlo = xmid + 1;
                ylo = ymid + 1;
            } else if (z2 <= o && z3 <= o) {
                xhi = xmid - 1;
                ylo = ymid + 1;
            } else return -1;
        }
        return -1;
    }
}
