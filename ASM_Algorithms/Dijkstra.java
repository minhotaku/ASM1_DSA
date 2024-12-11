import java.util.*;

public class Dijkstra {

    public static Map<Integer, Integer> shortestPath(Map<Integer, Map<Integer, Integer>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            Map<Integer, Integer> neighbors = graph.get(node);
            if (neighbors == null) continue;

            for (Map.Entry<Integer, Integer> neighbor : neighbors.entrySet()) {
                int nextNode = neighbor.getKey();
                int edgeWeight = neighbor.getValue();

                int newDist = dist + edgeWeight;
                if (newDist < distances.get(nextNode)) {
                    distances.put(nextNode, newDist);
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 4, 7, 8));
        graph.put(1, Map.of(2, 8, 7, 11));
        graph.put(2, Map.of(3, 7, 5, 4, 8, 2));
        graph.put(3, Map.of(4, 9, 5, 14));
        graph.put(4, Map.of(5, 10));
        graph.put(5, Map.of(6, 2));
        graph.put(6, Map.of(7, 1, 8, 6));
        graph.put(7, Map.of(8, 7));
        graph.put(8, new HashMap<>());
        int source = 0;
        Map<Integer, Integer> shortestPaths = shortestPath(graph, source);

        System.out.println("Shortest paths from node " + source + ":");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("  To node " + entry.getKey() + ": " + (entry.getValue() == Integer.MAX_VALUE ? "Infinity" : entry.getValue()));
        }
    }
}
