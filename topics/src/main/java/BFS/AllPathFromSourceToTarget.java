package BFS;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
    int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(0, new ArrayList<>(0), allPaths);
        return allPaths;
    }

    private void dfs(int src, List<Integer> path, List<List<Integer>> allPaths) {
        if (src == graph.length - 1) {
            allPaths.add(path);
            return;
        }

        for (int target : graph[src]) {
            path.add(target);
            dfs(target, path, allPaths);
            path.remove(target);
        }
    }
}
