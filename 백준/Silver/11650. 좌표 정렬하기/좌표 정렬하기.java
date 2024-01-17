import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];

        for (int i = 0; i < n; i++) {
            xy[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.stream(xy).sorted((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }).forEach(arr -> {
            try {
                bw.write(arr[0] + " " + arr[1] + "\n");
            } catch (IOException e) {
                //
            }
        });

        br.close();
        bw.flush();
        bw.close();
    }
}