
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 큐에 1~N 까지 넣기
        for (int i=0; i<N; i++){
            q.offer(i+1);
        }

        sb.append("<");

        while (q.size() != 1){
            for (int i=1; i<K; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
