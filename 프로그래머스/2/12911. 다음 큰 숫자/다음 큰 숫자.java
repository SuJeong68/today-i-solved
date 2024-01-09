class Solution {
    public int solution(int n) {
        int cnt = decimalToBinaryOneCnt(n);
        
        while (cnt != decimalToBinaryOneCnt(++n)) {}
        
        return n;
    }
    
    public int decimalToBinaryOneCnt(int n) {
        int cnt = 0;
        while (0 < n) {
            if (n % 2 == 1) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}