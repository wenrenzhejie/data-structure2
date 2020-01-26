package c05_union_find;

public class UnionFind {
    private int[] ids;
    private int size;

    public UnionFind(int n){
        this.size = n;
        ids = new int[n];
        for (int i = 0;i < n;i++){
            ids[i] = i;
        }
    }
    public int find(int p){
        //在此不做检验
        return ids[p];
    }
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }
    public void union(int p,int q){
        int pId = find(p);
        int qId = find(q);
        if (pId != qId){
            for (int i = 0;i < ids.length;i++){
                if (ids[i] == qId){
                    ids[i] = pId;
                }
            }
        }
    }
}
