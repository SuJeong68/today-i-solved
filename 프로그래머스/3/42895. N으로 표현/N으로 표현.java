import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> sets = new ArrayList<>();

        if (number == N) {
            return 1;
        }
        
        for (int i = 0; i < 8; i++) {
            sets.add(new HashSet<>());
            if (i == 0) {
                sets.get(0).add(N);
            }
            
            sets.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i + 1)));
            for (int j = 0; j < i; j++) {
                union(sets, i, j, i - j - 1);
            }

            if (sets.get(i).contains(number)) {
                return i + 1;
            }
        }

        return -1;
    }

    private void union(List<Set<Integer>> sets, int i, int j, int k) {
        Set<Integer> set = sets.get(i);
        for (int a : sets.get(j)) {
            for (int b : sets.get(k)) {
                set.add(a + b);
                set.add(a - b);
                set.add(a * b);
                if (b != 0) set.add(a / b);
            }
        }
        sets.set(i, set);
    }
}