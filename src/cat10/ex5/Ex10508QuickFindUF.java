package cat10.ex5;

public class Ex10508QuickFindUF {
    private int[] id;
    private int count;
    public Ex10508QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        // 错误的实现
        // 命令式编程带来的复杂度
        if (connected(p, q)) return;
        for (int i = 0; i < id.length;i++)
            if (id[i] == id[p]) id[i] = id[q];
        count--;
    }
    public int count() {
        return count;
    }
}
