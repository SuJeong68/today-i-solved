import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mid = 9999;
        int mod = 9999;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num + 4000]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int count = 0;
        int modMax = 0;

        boolean isFirst = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] <= 0) {
                continue;
            }

            if (count < (n + 1) / 2) {
                count += arr[i];
                mid = i - 4000;
            }

            if (modMax < arr[i]) {
                modMax = arr[i];
                mod = i - 4000;
                isFirst = true;
            } else if (modMax == arr[i] && isFirst) {
                mod = i - 4000;
                isFirst = false;
            }
        }

        bw.write((int) Math.round((double) sum / n) + "\n");
        bw.write(mid + "\n");
        bw.write(mod + "\n");
        bw.write((max - min) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
