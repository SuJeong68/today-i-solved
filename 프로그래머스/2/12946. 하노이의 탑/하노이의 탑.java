import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return result.toArray(new int[0][2]);
    }
    
    // t1 = 가장 큰 원판이 있는 타워
    // t2 = 비어있는 타워
    // t3 = 목표 타워
    public void hanoi(int n, int t1, int t2, int t3) {
        // n == 1 이면 가장 마지막 재귀 => 원판이 하나이므로 마무리
        if (n == 1) {
            result.add(new int[]{t1, t3});
            return;
        }
        
        // 가장 큰 판을 남겨두고 t1 -> t2로 이동을 목표
        hanoi(n - 1, t1, t3, t2);
                
        // 가장 큰 판을 t3을 옮김
        result.add(new int[]{t1, t3});
                
        // t2 -> t3으로 이동을 목표                
        hanoi(n - 1, t2, t1, t3);
    }
}