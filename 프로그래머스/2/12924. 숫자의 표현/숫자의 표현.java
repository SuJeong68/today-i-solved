class Solution {
    public int solution(int n) {
        int answer = 0;
        int head = 1;
        int tail = 1;
        int sum = 1;
        
        while (head <= tail) {
            if (sum == n) {
                answer++;
            }
            
            if (sum <= n) {
                tail++;
                sum += tail;
            } else {
                sum -= head;
                head++;
            }
        }
        
        return answer;
    }
}