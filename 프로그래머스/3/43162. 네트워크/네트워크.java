class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1) {
                DFS(i, i, computers);
                answer++;
            }
        }
        return answer;
    }

    public void DFS(int prev, int index, int[][] computers) {
        computers[index][prev] = 0;

        for (int i = 0; i < computers[index].length; i++) {
            if (computers[index][i] == 1) {
                computers[index][i] = 0;
                DFS(index, i, computers);
            }
        }
    }
}