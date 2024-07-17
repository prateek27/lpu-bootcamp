package CompetitiveProgramming.DSU;

public class DisjointSetUnion {
    //DSU (Union by Rank & Path Compression)
    private int[] parent;
    private int[] rank;

    DisjointSetUnion(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i=0;i<size;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]); //path compression
    }

    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootY!=rootX){
            //union by rank
            if(rank[rootX]>rank[rootY]){
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            else{
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}
