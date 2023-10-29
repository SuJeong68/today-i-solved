import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.collectingAndThen(
                Collectors.toSet(), 
                p -> Math.min(nums.length / 2, p.size())));
    }
}