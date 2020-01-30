package c07_graph_theory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {
    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] order;

    public ShortestPath(Graph graph,int s){
        assert s >= 0 && s < graph.getV();
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.getV()];
        from = new int[graph.getV()];
        order = new int[graph.getV()];
        for (int i = 0;i < graph.getV();i ++){
            from[i] = -1;
            order[i] = -1;
        }
        Queue<Integer> linkedList = new LinkedList<>();
        linkedList.add(s);
        visited[s] = true;
        order[s] = 0;
        while (!linkedList.isEmpty()){
            Integer v = linkedList.remove();
            for (int i : graph.adj(v)){
                if (!visited[i]){
                    linkedList.add(i);
                    visited[i] = true;
                    from[i] = v;
                    order[i] = order[v] + 1;
                }
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
    //从s到w的最短路径值
    public int length(int w){
        assert w >= 0 && w < graph.getV();
        return order[w];
    }
}
