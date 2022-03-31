package cat10.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10213Transaction implements Comparable<Ex10213Transaction> {
    private final String who;
    private final Ex10211SmartDate when;
    private final double amount;
    public Ex10213Transaction(String who, Ex10211SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    public Ex10213Transaction(String transaction) {
        String[] fields = transaction.split(" ");
        this.who = fields[0];
        this.when = new Ex10211SmartDate(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
    }
    public String who() {
        return who;
    }
    public Ex10211SmartDate when() {
        return when;
    }
    public double amount() {
        return amount;
    }
    public String toString() {
        return who() + " " + when() + " " + amount();
    }

    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        if (getClass() != that.getClass()) return false;
        Ex10213Transaction thatTransaction = (Ex10213Transaction) that;
        if (who.equals(thatTransaction.who) &&
                when.equals(thatTransaction.when) &&
                amount == thatTransaction.amount) return true;
        return false;
    }

    public int compareTo(Ex10213Transaction that) {
        double thatAmount = that.amount;
        if (amount > thatAmount) return 1;
        else if (amount < thatAmount) return -1;
        else return 0;
    }
    public int hashCode() {
        return super.hashCode();
    }

    public static Ex10213Transaction parseTransaction(String string) {
        String[] fields = string.split(" ");
        String who = fields[0];
        Ex10211SmartDate when = new Ex10211SmartDate(fields[1]);
        double amount = Double.parseDouble(fields[2]);
        return new Ex10213Transaction(who, when, amount);
    }

    public static void main(String[] args) {
        Ex10213Transaction transaction = new Ex10213Transaction("wusd", new Ex10211SmartDate(2, 19, 2009), 1.0);
        StdOut.println(transaction);
    }
}
