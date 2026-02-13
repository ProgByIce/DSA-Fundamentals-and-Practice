package DataStructures.Graph;

/**
 * Undirected graph represented through an Adjacency Matrix (a 2D array of size V x V where V is the number of vertices in a graph)
 * A value of 1 in the matrix indicates that there is an edge between the vertices and a value of 0 indicates that there is no edge between the vertices.
 * Code snippet from https://www.programiz.com/dsa/graph-adjacency-matrix
 */

public class UndirectedGraph {
    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public UndirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        UndirectedGraph g = new UndirectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}