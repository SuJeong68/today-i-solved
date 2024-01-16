import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 카드 합 M 넘지 않음
        // M과 최대한 가깝게 3장
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        for (int target = nm[1];; target--) {
            if (findTarget(nums, target, bw)) {
                bw.write(Integer.toString(target));
                break;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean findTarget(int[] nums, int target, BufferedWriter bw) {
        for (int idx = 0; idx < nums.length - 2; idx++) {
            for (int i = idx + 1; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[idx] + nums[i] + nums[j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
