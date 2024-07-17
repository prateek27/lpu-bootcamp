package CompetitiveProgramming.DSU;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    static class Edge{
        int src, dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    //Graph data members
    int V;
    private List<Edge> edgeList;

    public Graph(int V){
        this.V = V;
        this.edgeList = new ArrayList<>();
    }

    void addEdge(int u,int v){
        edgeList.add(new Edge(u,v));
    }

    public boolean detectCycle(){
        DisjointSetUnion dsu = new DisjointSetUnion(V);

        for(Edge e:edgeList){
            int u = e.src;
            int v = e.dest;

            int rootU = dsu.find(u);
            int rootV = dsu.find(v);

            if(rootV==rootU){
                return true;
            }
            dsu.union(u,v);
        }
        return false;
    }

}
