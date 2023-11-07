class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] prefix = new int[n + 1][m + 1];
        
        // 누적합 범위 지정
        for (int[] sk : skill) {
            int degree = (sk[0] == 1 ? -1 : 1) * sk[5];
            prefix[sk[1]][sk[2]] += degree;
            prefix[sk[1]][sk[4] + 1] += (-degree);
            prefix[sk[3] + 1][sk[2]] += (-degree);
            prefix[sk[3] + 1][sk[4] + 1] += degree;
        }
        
        // 누적합 계산
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }
        
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += prefix[j][i];
                prefix[j][i] = sum;
            }
        }
        
        // 누적합 적용
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefix[i][j] + board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}