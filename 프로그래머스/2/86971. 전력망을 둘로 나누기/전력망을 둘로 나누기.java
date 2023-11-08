class Solution {
    private boolean[] visited;
    private int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        for (int i = 0; i < n - 1; i++) {
            visited = new boolean[n + 1];
            dfs(i, wires, wires[i][0]);

            int count = 0;
            for (boolean visit : visited) {
                if (visit)  count++;
            }
            min = Math.min(min, Math.abs(count * 2 - n));
        }
        return min;
    }

    public void dfs(int idx, int[][] wires, int current) {
        visited[current] = true;
        for (int i = 0; i < wires.length; i++) {
            if (i == idx) {
                continue;
            }

            int[] wire = wires[i];
            if (wire[0] == current || wire[1] == current) {
                int target = wire[0] != current ? wire[0] : wire[1];
                if (!visited[target]) {
                    dfs(idx, wires, target);
                }
            }
        }
    }
}