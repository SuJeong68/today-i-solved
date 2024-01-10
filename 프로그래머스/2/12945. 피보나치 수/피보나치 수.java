class Solution {
    public int solution(int n) {
        int[] fibonacci = new int[]{1, 0, 1};
        
        int current = 2;
        while (n != current++) {
            fibonacci[1] = fibonacci[2];
            fibonacci[2] = fibonacci[0];
            fibonacci[0] = fibonacci[1] % 1234567 + fibonacci[2] % 1234567;
        }
        
        return fibonacci[0] % 1234567;
    }
}