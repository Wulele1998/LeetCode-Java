package OA;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPath {
    public static final int INF = Integer.MAX_VALUE;
    
    int n; // number of nodes from 0 to n - 1
    int[][] edges; // edges, [start, end, weight]
    int[][] result;
    int[][] nextNode;
    List<List<int[]>> graph;

    public ShortestPath(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;

        result = new int[n][n];
        nextNode = new int[n][n]; // find the next node to know the shortest path
        graph = new ArrayList<>();

        // init the arrays
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], INF);
            result[i][i] = 0;
            Arrays.fill(nextNode[i], -1);
            graph.add(new ArrayList<>());
        }
    }

    public void floydWarshall() {
        // build the adjacent graph
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph.get(start).add(new int[] {end, weight});
            result[start][end] = weight;
            nextNode[start][end] = end;
        }

        // start Floyd-Warshall 
        for (int k = 0; k < n; k++) {
            // each node play as the intermediate node
            for (int i = 0; i < n; i++) {
                // i as the start node
                for (int j = 0; j < n; j++) {
                    // j as the end node
                    if (result[i][k] != INF && result[k][j] != INF && result[i][k] + result[k][j] < result[i][j]) {
                        // node i to node k is reachable and node k to node j is reachable
                        // start the relax operation
                        result[i][j] = result[i][k] + result[k][j];
                        nextNode[i][j] = k; // update the nextNode array
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (result[i][i] != 0) {
                // the graph has negative cycle, cannot use Floyd-Warshall
                System.out.println("The graph contains negative cycle. Cannot use Floyd-Warshall Algorithm");
                return;
            }
        }

        System.out.println("Floyd-Warshall Algorithm completed");
    }

    public void dijkstra(int startNode) {
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph.get(start).add(new int[] {end, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // [node number, prev node number, distance from start node]
        boolean[] visited = new boolean[n]; // default value is false

        minHeap.add(new int[] {startNode, startNode, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int nodeId = current[0];
            int prevNodeId = current[1];
            int distanceFromStart = current[2];

            if (visited[nodeId]) {
                continue;
            }

            visited[nodeId] = true;
            result[startNode][nodeId] = distanceFromStart;
            nextNode[startNode][nodeId] = prevNodeId;
            nextNode[prevNodeId][nodeId] = nodeId;

            for (int[] adj : graph.get(nodeId)) {
                // relax operation
                if (result[startNode][adj[0]] > distanceFromStart + adj[1]) {
                    result[startNode][adj[0]] = distanceFromStart + adj[1];
                    minHeap.add(new int[] {adj[0], nodeId, result[startNode][adj[0]]});
                }
            }
        }
    }

    public void getShortestPath(int start, int end) {
        if (result[start][end] == INF) {
            System.out.println("Start node cannot reach the end node");
            return;
        }

        System.out.println("The cost of the shortest path from the start node to the end node is: " + result[start][end]);
        System.out.println("The shortest path from the start node to the end node is: " + getPath(start, end));
        
        System.out.println("Print the shortest path result:");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        System.out.println("Print the nextNode path array:");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(nextNode[i]));
        }
    }

    private String getPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        path.add(start);

        while (nextNode[start][end] != end) {
            start = nextNode[start][end];
            path.add(start);
        }

        path.add(end);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            sb.append(path.get(i) + "->");
        }
        sb.append(path.get(path.size() - 1));

        return sb.toString();
    }
}