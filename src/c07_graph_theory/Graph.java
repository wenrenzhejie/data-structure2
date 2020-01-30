package c07_graph_theory;

public interface Graph {
    public int getV();
    public int getE();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}
