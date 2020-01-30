package c07_graph_theory;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Vector;

//稠密图-使用邻接矩阵
public class DenseGraph implements Graph{
    //顶点数
    private int n;
    //边数
    private int m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n,boolean directed){
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }
    //顶点数
    public int getV(){
        return this.n;
    }
    //边数
    public int getE(){
        return this.m;
    }
    public boolean hasEdge(int v,int w){
        return g[v][w];
    }

    @Override
    public void show() {
        for (int i = 0;i < n;i ++){
            for (int j = 0;j < n;j ++){
                int res = g[i][j] ? 1 : 0;
                System.out.print("\t" + res);
            }
            System.out.println();
        }
    }

    public void addEdge(int v,int w){
        if (v < 0 || v >= n || w < 0 || w >= n){
            throw new IndexOutOfBoundsException("索引越界异常");
        }
        if (hasEdge(v,w)){
            return;
        }
        g[v][w] = true;
        if (!directed){
            g[w][v] = true;
        }
        this.m ++;
    }
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0;i < n;i ++){
            if (g[v][i]){
                adjV.add(i);
            }
        }
        return adjV;
    }
}
