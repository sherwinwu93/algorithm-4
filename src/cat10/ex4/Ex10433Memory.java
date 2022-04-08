package cat10.ex4;

public class Ex10433Memory {
    // 32位 操作系统
    // Integer: 16
    // Date: 24
    // Counter: 20
    // int[]: 4N + 16
    // double[]: 8 + 4 + 4 + 8*N = 8N+16
    // double[][]: 8 + 4 + 4 + 4N + N(8 + 4 + 4 + 8N) = 8N^2 + 20N + 16
    // String: 8 + 4 + 4 + 4 + 4 + (8 + 4 + 4 + N)
    // Node: N(8 + 4 + 4 )
    // Stack(链表): 8 + 4 + 4 + N(8 + 4 + 4)
}
