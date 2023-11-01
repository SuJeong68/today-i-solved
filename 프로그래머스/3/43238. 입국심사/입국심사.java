import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = times[0];
        long end = (long) times[times.length - 1] * n;
        
        long mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            
            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }
            
            if (n <= cnt) {
                end = mid;
            } else {
                start = mid + 1; 
            }
        }
        return start;
    }
}