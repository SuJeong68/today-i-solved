class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int sum = 0;
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            sum += i + 1;
            triangle[i] = new int[i + 1];
        }
        int[] result = new int[sum];
        
        int current = 1;
        int idx = 0;
        int term = n;
        
        int x = -1;
        int y = 0;
        while (current <= sum) {
            int[] direction = directions[idx];
            for (int i = 0; i < term; i++, current++) {
                x += direction[0];
                y += direction[1];
                triangle[x][y] = current;
            }

            idx = idx + 1 < 3 ? idx + 1 : 0;
            term--;
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }
}