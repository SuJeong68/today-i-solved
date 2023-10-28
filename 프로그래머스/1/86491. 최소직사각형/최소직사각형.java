import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] sizes) {
        List<int[]> list = Arrays.stream(sizes)
            .map(card -> {
                if (card[0] < card[1]) {
                    int temp = card[0];
                    card[0] = card[1];
                    card[1] = temp;
                }
                return card;
            })
            .collect(Collectors.toList());
    
        int maxW = 0;
        int maxH = 0;
        for (int[] card : list) {
            maxW = Math.max(card[0], maxW);
            maxH = Math.max(card[1], maxH);
        }
        return maxW * maxH;
    }
}