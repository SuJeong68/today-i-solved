class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int current = 0;
        int tube = p;
        
        for (int i = 0; i <= t * m; i++) {
            String temp = Integer.toString(i, n).toUpperCase();
            for (int j = 0; j < temp.length(); j++) {
                if (++current == tube) {
                    sb.append(temp.charAt(j));
                    tube += m;
                    
                    if (sb.length() == t)
                        return sb.toString();
                }
            }
        }
        
        return sb.toString();
    }
}