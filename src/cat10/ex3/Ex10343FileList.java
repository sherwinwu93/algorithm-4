package cat10.ex3;

import cat10.P095Queue;

import java.io.File;

public class Ex10343FileList {
    // 文件列表
    public static void main(String[] args) {
//        String filename = args[0];
        String filename = "C:\\Users\\wusd\\codes\\algorithm-4\\target\\classes\\cat10";
        File file = new File(filename);
        P095Queue<File> queue = new P095Queue<File>();
        enqueue(file, queue);
        System.out.println();
    }
    private static void enqueue(File file, P095Queue<File> queue) {
        queue.enqueue(file);
        if (file.listFiles() == null) return;
        for (File f : file.listFiles()) {
            enqueue(f, queue);
        }
    }
}
