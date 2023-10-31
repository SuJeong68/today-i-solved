class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        for (int h = 3; h <= Math.round(area / 3); h++) {
            int w = area / h;
            if (area % h == 0 && yellow == (h - 2) * (w - 2)) {
                return new int[]{w, h}; 
            }
        }
        throw new RuntimeException();
    }
}