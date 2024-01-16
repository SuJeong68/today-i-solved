import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> cards = new HashMap<>();
        for (String card : br.readLine().split(" ")) {
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] owns = br.readLine().split(" ");
        int[] ownCnt = new int[m];
        for (int i = 0; i < m; i++) {
            ownCnt[i] = cards.getOrDefault(owns[i], 0);
        }

        for (int cnt : ownCnt) {
            bw.write(cnt + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
