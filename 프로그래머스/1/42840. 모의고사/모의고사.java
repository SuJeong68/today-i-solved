import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] students = new int[][]{
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int max = 0;
        int[] answer = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[j][i % students[j].length] == answers[i]) {
                    answer[j]++;
                    max = Math.max(answer[j], max);
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != max) {
                answer[i] = -1;
            } else {
                answer[i] = i + 1;
            }
        }
        
        return Arrays.stream(answer)
            .filter(a -> a != -1)
            .sorted()
            .toArray();
    }
}