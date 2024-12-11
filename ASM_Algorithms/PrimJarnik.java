import java.util.*;

public class PrimJarnik {

    public static List<int[]> minimumSpanningTree(Map<Integer, Map<Integer, Integer>> graph) {
        List<int[]> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int startNode = graph.keySet().iterator().next();
        visited.add(startNode);

        for (Map.Entry<Integer, Integer> neighbor : graph.get(startNode).entrySet()) {
            pq.offer(new int[]{startNode, neighbor.getKey(), neighbor.getValue()});
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node1 = curr[0];
            int node2 = curr[1];
            int weight = curr[2];

            if (visited.contains(node2)) {
                continue;
            }
            visited.add(node2);
            mst.add(curr);

            for (Map.Entry<Integer, Integer> neighbor : graph.get(node2).entrySet()) {
                int nextNode = neighbor.getKey();
                int nextWeight = neighbor.getValue();
                if (!visited.contains(nextNode)) {
                    pq.offer(new int[]{node2, nextNode, nextWeight});
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 4, 7, 8));
        graph.put(1, Map.of(0, 4, 2, 8, 7, 11));
        graph.put(2, Map.of(1, 8, 3, 7, 5, 4, 8, 2));
        graph.put(3, Map.of(2, 7, 4, 9, 5, 14));
        graph.put(4, Map.of(3, 9, 5, 10));
        graph.put(5, Map.of(2, 4, 3, 14, 4, 10, 6, 2));
        graph.put(6, Map.of(5, 2, 7, 1, 8, 6));
        graph.put(7, Map.of(0, 8, 1, 11, 6, 1, 8, 7));
        graph.put(8, Map.of(2, 2, 6, 6, 7, 7));

        List<int[]> mst = minimumSpanningTree(graph);

        System.out.println("Minimum Spanning Tree:");
        for (int[] edge : mst) {
            System.out.println("  " + edge[0] + " - " + edge[1] + " : " + edge[2]);
        }
    }
}