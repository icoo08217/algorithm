
import java.util.*;
import java.io.*;

class baek10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // deque를 링크드 리스트로 구현
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int x = -1;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            switch (type){
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                    break;

                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                    break;

                case "pop_front" :
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else {
                        sb.append(deque.peek()).append("\n");
                        deque.removeFirst();
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else {
                        sb.append(deque.peekLast()).append("\n");
                        deque.removeLast();
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;

                case "front":
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peek()).append("\n");
                    break;

                case "back":
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;

            }
        }

        System.out.println(sb);

    }
}
