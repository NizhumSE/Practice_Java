import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sorting edges by weight
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent, rank;

    DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Each node is its own parent
            rank[i] = 0;   // Rank starts at 0
        }
    }

    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalMST {
    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();


        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(2, 4, 4));
        edges.add(new Edge(3, 4, 6));


        List<Edge> mst = findMST(edges, vertices);

   
        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight: " + totalWeight);
    }

    public static List<Edge> findMST(List<Edge> edges, int vertices) {
        
        Collections.sort(edges);


        DisjointSet ds = new DisjointSet(vertices);

        List<Edge> mst = new ArrayList<>();

    
        for (Edge edge : edges) {
            int rootSrc = ds.find(edge.src);
            int rootDest = ds.find(edge.dest);


            if (rootSrc != rootDest) {
                mst.add(edge);
                ds.union(rootSrc, rootDest);
            }

         
            if (mst.size() == vertices - 1) {
                break;
            }
        }
        return mst;
    }
}
