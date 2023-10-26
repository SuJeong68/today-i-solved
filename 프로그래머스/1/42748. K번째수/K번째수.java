import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            sort(arr, 0, arr.length - 1);
            result[i] = arr[commands[i][2] - 1];
        }
        return result;
    }
    
    // 퀵 정렬
    public void sort(int[] arr, int start, int end) {
        // 중간값
        int mid = (start + end) / 2;
        int left = start;
        int right = end;
        
        do {
            while (arr[start] < arr[mid]) {
                start++;
            }
            while (arr[end] > arr[mid]) {
                end--;
            }
            if (start <= end) {
                swap(arr, start++, end--);
            }
        } while (start <= end);
        
        if (left < end) {
            sort(arr, left, end);
        }
        if (right > start) {
            sort(arr, start, right);
        }
    }
    
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}