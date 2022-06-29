package cat30;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by Wusd on 2022/6/29.
 * 给文件增加索引,
 * 对文件中的每个词,都给出对应的文件
 **/
public class FileIndex {
    public static void main(String[] args) {
        ST<String, SET<File>> st = new ST<>();

        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println(filename);
            File file = new File(filename);
            In in = new In(filename);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new SET<>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }

        while (!StdIn.isEmpty()) {
            String keyword = StdIn.readString();
            if (st.contains(keyword)) {
                SET<File> files = st.get(keyword);
                for (File file : files) {
                    StdOut.println(file.getName());
                }
            } else {
                StdOut.println("Not found");
            }
        }
    }
}
/**
 * % java cat30.FileIndex ex*.txt
 * Indexing files
 * ex1.txt
 * ex2.txt
 * ex3.txt
 * ex4.txt
 * it
 * ex1.txt
 * ex2.txt
 * ex3.txt
 * ex4.txt
 * wa
 * Not found
 * was
 * ex1.txt
 * ex2.txt
 * ex3.txt
 * ex4.txt
 **/