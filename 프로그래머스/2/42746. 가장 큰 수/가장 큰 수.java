import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2))
            .collect(Collectors.joining());
        
        return result.startsWith("0") ? "0" : result;
    }
}
