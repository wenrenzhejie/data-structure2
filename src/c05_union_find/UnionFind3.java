package c05_union_find;

public class UnionFind3 {
    private int[] parent;
    private int[] count;
    private int size;

    public UnionFind3(int n){
        this.size = n;
        parent = new int[n];
        count = new int[n];
        for (int i = 0;i < n;i++){
            parent[i] = i;
            count[i] = 1;
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
            if (count[pId] > count[qId]){
                parent[qId] = pId;
                count[pId] += count[qId];
            }else {
                parent[pId] = qId;
                count[qId] += count[pId];
            }
        }
    }
}
