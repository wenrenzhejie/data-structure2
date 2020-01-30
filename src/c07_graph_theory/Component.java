package c07_graph_theory;
//深度优先遍历+图的连通分量
public class Component {
    private Graph graph;
    private boolean[] visited;
    //节点是否连通
    private int[] id;
    //有几个连通分量
    private int count;
    public Component(Graph graph){
        this.graph = graph;
        visited = new boolean[graph.getV()];
        id = new int[graph.getV()];
        for (int j = 0;j < id.length;j ++){
            id[j] = -1;
        }
        for (int i = 0;i < graph.getV();i ++){
            if (!visited[i]){
                dfs(i);
                count ++;
            }
        }
    }
    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        for (int i : graph.adj(v)){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
    public int getCount(){
        return this.count;
    }
    public boolean isConnected(int v,int w){
        assert v >= 0 && v < id.length;
        assert w >= 0 && w < id.length;
        return id[v] == id[w];
    }
}
