import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(strs[0]);
            input[i][1] = Integer.parseInt(strs[1]);
        }

        Arrays.sort(input, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });

        for (int[] arr : input) {
            System.out.println(arr[0] + " " + arr[1]);
        }

        br.close();
    }
}
