class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0", "");
            
            answer[1] += len - s.length();
            len = s.length();
            
            answer[0]++;

            StringBuilder binary = new StringBuilder();
            while (len != 0) {
                int m = len % 2;
                binary.append(m);
                len /= 2;
            }
            s = binary.reverse().toString();
        }

        return answer;
    }
}