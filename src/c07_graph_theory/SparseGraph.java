package c07_graph_theory;

import java.util.Iterator;
import java.util.Vector;

//稀疏图-使用邻接表实现
public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n,boolean directed){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0;i < n;i ++){
            g[i] = new Vector<>();
        }
    }
    public int getV(){
        return this.n;
    }
    public int getE(){
        return this.m;
    }
    /*判定两个节点之间有没有边，时间复杂度是O（n）,因此在addEdge（）中
    * 未进行判断，因此使用邻接表实现图就可能产生平行边
    * */
    public boolean hasEdge(int v,int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0;i < g[v].size();i ++){
            if (g[v].get(i) == w){
                return false;
            }
        }
        return true;
    }

    @Override
    public void show() {
        for (int i = 0;i < n;i ++){
            System.out.print("Vertex"+i+"\t");
            for (int j = 0;j < g[i].size();j ++){
                System.out.print("\t"+g[i].get(j));
            }
            System.out.println();
        }
    }

    public void addEdge(int v,int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        g[v].add(w);
        if (v != w && !directed){
            g[w].add(v);
        }
    }
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        return g[v];
    }
}
