package c07_graph_theory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.AlgorithmConstraints;
import java.util.Locale;
import java.util.Scanner;

public class ReadGraph {
    private Scanner scanner;
    public ReadGraph(Graph graph,String fileName){
        readFile(fileName);
        int V = scanner.nextInt();
        if (V < 0){
            throw new IllegalArgumentException("所给顶点数不能为负数");
        }
        assert  V == graph.getV();
        int E = scanner.nextInt();
        if (E < 0){
            throw new IllegalArgumentException("所给边数不能为负数");
        }
        for (int i = 0;i < E;i ++){
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            assert v >= 0 && v < V;
            assert w >= 0 && w < V;
            graph.addEdge(v,w);
        }
    }
    private void readFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream),"UTF-8");
//                scanner.useLocale(Locale.ENGLISH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件不存在");
        }
    }
}
