import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int n;
    private LinkedList<Integer> adjList[];
    private Queue<Integer> q = new LinkedList();

    // creating adjacency list for each vertex.
    public void makeGraph(int no) {
        n = no;
        adjList = new LinkedList[no];

        int i;

        for (i = 0; i < no; i++) {
            adjList[i] = new LinkedList();
        }
    } // End makeGraph

    // adding edges to graph
    public void addEdgeToGraph(int u, int v) {
        adjList[u].add(v);
    }

    // BFtraversal function traverse one connect component of graph
    public void BFtraversal(int v, boolean[] visited) {
        q.add(v); // index of visited node
        visited[v] = true; // v is the index of visted node

        int k;

        while(!q.isEmpty()) {
            k = q.remove(); // pop visited index from queue
            System.out.print(k + " ");
            // we are iterating thorough adjacency list of vertex k which has to be explored now
            // it will give the adjacent nodes of each vertex
            Iterator<Integer> i = adjList[k].listIterator(); // adjList contains all the edges to current node k
            int j;

            while(i.hasNext()) {
                j = i.next();
                if(visited[j] != true) {
                    // if any child found without visiting then those child will be added to queue.
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    } // End BFtraversal

    // BFsearch function will maintain boolean array to know which vertex is explored.
    // If in case of disconnected graph it will again call BFtravesal on another component
    public void BFsearch(int v) {
        boolean visited[] = new boolean[n]; // n size of graph??

        BFtraversal(v, visited);
        for (int i = 0; i < n; i++) {
            // after calling VFtraversal it is checking whether any vertext left out wiht out exploring
            if(visited[i] != true) {
                // if found it will call again BFtraversal
                BFtraversal(i, visited);
            }
        }
    }

    public static void main(String args[])
    {
        BFS obj = new BFS();

        //make graph will make 10 vertices and it will maintain an adjacency list for each vertex.
//        obj.makeGraph(10);
//
//        obj.addEdgeToGraph(0, 1);
//        obj.addEdgeToGraph(0, 9);
//        obj.addEdgeToGraph(2, 3);
//        obj.addEdgeToGraph(2, 4);
//        obj.addEdgeToGraph(3, 5);
//        obj.addEdgeToGraph(3, 6);
//        obj.addEdgeToGraph(4, 7);
//        obj.addEdgeToGraph(4, 8);
        obj.makeGraph(10);
        obj.addEdgeToGraph(0, 1);
        obj.addEdgeToGraph(0, 4);
        obj.addEdgeToGraph(1, 2);
        obj.addEdgeToGraph(2, 3);
        obj.addEdgeToGraph(2, 4);
        obj.addEdgeToGraph(3, 5);
        obj.addEdgeToGraph(3, 7);
        obj.addEdgeToGraph(4, 6);
        obj.addEdgeToGraph(4, 8);
        obj.addEdgeToGraph(5, 6);
        obj.addEdgeToGraph(5, 9);
        obj.addEdgeToGraph(6, 7);
        obj.addEdgeToGraph(7, 8);
        obj.addEdgeToGraph(8, 9);

        System.out.println("BFS of graph is:");

        // we are starting search from 0th vertex.
        obj.BFsearch(0);
    }




} // End BFS
