import java.util.*;
import java.io.*;

class baek10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int intNum = -1;

        // 정수를 저장할 수 있는 큐
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            switch (type){
                case "push":
                    intNum = Integer.parseInt(st.nextToken());
                    q.offer(intNum);
                    break;

                case "pop":
                    if (!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                        break;
                    }
                    else {
                        sb.append("-1").append("\n");
                        break;
                    }

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                    break;

                case "back":
                    sb.append(q.isEmpty() ? -1 : intNum).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}