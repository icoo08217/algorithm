import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.offer(num);
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num); // 20번 offer하고 ,
                pq.poll(); // 20번 poll 하게 된다.
            }
        }
        // 결국 5개의 숫자만이 남는데 우선순위 큐에서 poll을 하게 된다면 n번째로 큰 수가 뽑힌다.
        System.out.println(pq.poll());
    }
}
