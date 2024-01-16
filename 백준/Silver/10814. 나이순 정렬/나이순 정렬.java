import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[][] members = new String[n][2];
        for (int i = 0; i < n; i++) {
            members[i] = br.readLine().split(" ");
        }

        Arrays.stream(members).sorted(Comparator.comparingInt(o -> Integer.parseInt(o[0]))).forEach(strings -> {
            try {
                bw.write(strings[0] + " " + strings[1] + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        br.close();
        bw.flush();
        bw.close();
    }
}
