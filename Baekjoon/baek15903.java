import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        st = new StringTokenizer(br.readLine());

        Long n = Long.parseLong(st.nextToken());
        Long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Long temp = Long.parseLong(st.nextToken());
            pq.offer(temp);
        }

        while(m > 0) {
            Long cardX = pq.poll();
            Long cardY = pq.poll();

            Long cardXY = cardX + cardY;
            pq.offer(cardXY);
            pq.offer(cardXY);
            m--;
        }


        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);

    }
}
