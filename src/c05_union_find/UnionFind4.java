package c05_union_find;

public class UnionFind4 {
    private int[] parent;
    private int[] rank;
    private int size;

    public UnionFind4(int n){
        this.size = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0;i < n;i++){
            parent[i] = i;
            rank[i] = 1;
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
            if (rank[pId] > rank[qId]){
                parent[qId] = pId;
            }else if (rank[pId] < rank[qId]){
                parent[pId] = qId;
            }else {
                parent[qId] = pId;
                rank[pId] += 1;
            }
        }
    }
}
