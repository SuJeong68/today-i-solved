class Solution {
    public int solution(String numbers) {
        // 숫자 개수 세기
        int[] cnts = new int[10];
        for (String s: numbers.split("")) {
            cnts[Integer.parseInt(s)]++;
        }

        // 가장 큰 수 조합
        StringBuilder sb = new StringBuilder();
        for (int i = cnts.length - 1; i >= 0; i--) {
            for (int j = 0; j < cnts[i]; j++) {
                sb.append(i);
            }
        }
        int max = Integer.parseInt(sb.toString());

        // 가장 큰 수 까지의 소수 탐색
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

        // 총 개수 세기
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            boolean flag = false;
            for (int j = 0; j <= 9; j++) {
                final int fin = j;
                long cnt = String.valueOf(i).chars().filter(c -> Character.getNumericValue(c) == fin).count();
                if (cnt != 0) {
                    if (cnts[j] < cnt) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }
            }
            if (primes[i] && flag) {
                count++;
            }
        }
        return count;
    }
}