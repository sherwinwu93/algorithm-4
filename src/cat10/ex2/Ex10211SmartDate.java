package cat10.ex2;

import lib.ArrayUtils;

public class Ex10211SmartDate {
    private final int month;
    private final int day;
    private final int year;
    private final static int[] bigMonths = {1, 3, 5, 7, 8, 10, 12};
    private final static int[] smallMonths = {4, 6, 9, 11};

    public Ex10211SmartDate(int m, int d, int y) {
        validate(m, d, y);
        month = m;
        day = d;
        year = y;
    }

    public Ex10211SmartDate(String date) {
        String[] fields = date.split("/");
        int m= Integer.parseInt(fields[0]);
        int d= Integer.parseInt(fields[1]);
        int y= Integer.parseInt(fields[2]);
        validate(m, d, y);
        month = m;
        day = d;
        year = y;
    }

    private void validate(int m, int d, int y) {
        if (m < 1 || m > 12) throw new RuntimeException("error date");
        if (d < 1) throw new RuntimeException("error date");
        if (ArrayUtils.contains(bigMonths, m)) {
            // 31
            if (d > 31) throw new RuntimeException("error date");
        } else if (ArrayUtils.contains(smallMonths, m)) {
            // 30
            if (d > 30) throw new RuntimeException("error date");
        } else {
            //29
            if (isLeap(y)) if (d > 29) throw new RuntimeException("error date");
            else if (d > 28) throw new RuntimeException("error date");
        }
    }

    private boolean isLeap(int y) {
        return (y % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String dayOfTheWeek() {
        if (day == 1) return "Monday";
        else if (day == 2) return "Tuesday";
        else if (day == 3) return "Wednesday";
        else if (day == 4) return "Thursday";
        else if (day == 5) return "Friday";
        else if (day == 6) return "Saturday";
        else return "Sunday";
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
        return month() + "/" + day() + "/" + year();
    }

    public static void main(String[] args) {
        Ex10211SmartDate date = new Ex10211SmartDate(6,31,2009);
        Ex10211SmartDate date2 = new Ex10211SmartDate(2,29,2009);
    }
}
