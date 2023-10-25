class Solution {
    // 다시 풀어봐...
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long result = -1;
        long start = 1;
        long end = (long) (4 * Math.pow(10, 14) + Math.pow(10, 5));

        while (start <= end) {
            long mid = (start + end) / 2;

            int gold = 0;
            int silver = 0;
            int sum = 0;
            for (int i = 0; i < t.length; i++) {
                long move = mid / (t[i] * 2);
                if (mid % (t[i] * 2) >= t[i]) {
                    move++;
                }

                long tmp = Math.min(g[i] + s[i], move * w[i]);
                sum += tmp;

                gold += Math.min(g[i], tmp);
                silver += Math.min(s[i], tmp);
            }

            if (a <= gold && b <= silver && a + b <= sum) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}