import OA.ShortestPath;

public class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{0, 3, 5}, {0, 1, 3}, {1, 0, 2}, {1, 3, 4}, {2, 1, 6}, {3, 2, 2}};
        ShortestPath floydWarshall = new ShortestPath(4, edges);

        floydWarshall.floydWarshall();
        floydWarshall.getShortestPath(1, 2);

        ShortestPath dijkstra = new ShortestPath(4, edges);
        dijkstra.dijkstra(1);
        dijkstra.getShortestPath(1, 2);
    }
}
