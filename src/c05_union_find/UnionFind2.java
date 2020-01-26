package c05_union_find;

public class UnionFind2 {
    private int[] parent;
    private int size;

    public UnionFind2(int n){
        this.size = n;
        parent = new int[n];
        for (int i = 0;i < n;i++){
            parent[i] = i;
        }
    }
    public int find(int p){
        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }
    public void union(int p,int q){
        int pId = find(p);
        int qId = find(q);
        if (pId != qId){
            parent[p] = qId;
        }
    }
}
