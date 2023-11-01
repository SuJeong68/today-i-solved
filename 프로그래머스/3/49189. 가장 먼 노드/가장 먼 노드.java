import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        List<Integer>[] relations = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            relations[edge[0]].add(edge[1]);
            relations[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        int depth = 0;
        int[] dp = new int[n + 1];
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            
            if (depth < dp[idx]) {
                depth = dp[idx];
            }
            
            for (int node : relations[idx]) {
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                queue.add(node);
                dp[node] = depth + 1;
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (depth == dp[i]) {
                count++;
            }
        }
        
        return count++;
    }
}