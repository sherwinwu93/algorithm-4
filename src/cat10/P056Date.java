package cat10;

import java.util.Date;

public class P056Date {
    private final int month;
    private final int day;
    private final int year;

    public P056Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day()
                + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (x.getClass() != getClass()) return false;
        P056Date that = (P056Date) x;
        return that.month == month && that.day == day && that.year == year;
    }
}
