package c07_graph_theory;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private Graph graph;
    //起始点
    private int s;
    private boolean[] visited;
    //记录每一个顶点是从哪个顶点过来的
    private int[] from;

    public Path(Graph graph,int s){
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.getV()];
        from = new int[graph.getV()];
        for (int i = 0;i < graph.getV();i ++){
            from[i] = -1;
        }
        //寻路算法
        dfs(s);
    }
    private void dfs(int v) {
        visited[v] = true;
        for (int i : graph.adj(v)){
            if (!visited[i]){
                from[i] = v;
                dfs(i);
            }
        }
    }
    //从s到w是否有路
    public boolean hasPath(int w){
        assert w >= 0 && w < graph.getV();
        return visited[w];
    }
    public void path(int w, Vector<Integer> vector){
            Stack<Integer> stack = new Stack<>();
            int p = w;
            while (p != -1){
                stack.push(p);
                p = from[p];
            }
            while (!stack.isEmpty()){
                vector.add(stack.pop());
            }
    }
    public void showPath(int w){
        Vector<Integer> vector = new Vector<>();
        path(w,vector);
        for (int i = 0;i < vector.size();i ++){
            System.out.print(vector.get(i) + "\t");
        }
    }
}
