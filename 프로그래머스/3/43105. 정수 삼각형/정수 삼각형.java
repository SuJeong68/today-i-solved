class Solution {
    public int solution(int[][] triangle) {
        int max = 0;
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            
            if (i >= 2) {
                for (int j = 1; j < triangle[i].length - 1; j++) {
                    triangle[i][j] 
                        = Math.max(triangle[i-1][j] + triangle[i][j], triangle[i-1][j-1] + triangle[i][j]);
                    max = Math.max(triangle[i][j], max);
                }
            }
        }
        return max;
    }
}