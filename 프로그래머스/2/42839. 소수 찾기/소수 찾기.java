import java.util.*;

class Solution {
    HashSet<Integer> hashSet;

    public int solution(String numbers) {
        hashSet = new HashSet<>();
        permutation("", numbers);

        int max = 0;
        for (int n : hashSet) {
            max = Math.max(n, max);
        }

        boolean[] primes = new boolean[max + 1];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < Math.sqrt(max); i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = i + i; j <= max; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] && hashSet.contains(i)) {
                count++;
            }
        }

        return count;
    }

    public void permutation(String prefix, String str) {
        int len = str.length();
        if (!prefix.equals("")) {
            hashSet.add(Integer.valueOf(prefix));
        }

        for (int i = 0; i < len; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
        }
    }

}
