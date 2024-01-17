import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("<");
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= nk[0]; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < nk[1]; i++) {
                queue.add(queue.poll());
            }
            bw.write(Integer.toString(queue.poll()));

            if (!queue.isEmpty()) {
                bw.write(", ");
            }
        }

        bw.write(">");

        br.close();
        bw.flush();
        bw.close();
    }
}
