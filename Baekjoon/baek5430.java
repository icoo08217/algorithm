
import java.util.*;
import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque;
        StringTokenizer str;

        int T = Integer.parseInt(br.readLine());

        while( T --> 0) {

            deque = new ArrayDeque<Integer>();
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            str = new StringTokenizer(br.readLine(), "[],"); // 구분자를 통째로 넣어주면 된다.

            for (int j = 0; j < n; j++) { // 덱에 배열의 원소를 입력
                deque.add(Integer.parseInt(str.nextToken()));
            }

            //함수대로 로직 수행
            AC(command , deque);
        }

        System.out.println(sb);

    }

    public static void AC(String command , ArrayDeque<Integer> deque){
        boolean isRotate = true;

        for (char cmd : command.toCharArray()){
            if (cmd =='R') {
                isRotate = !isRotate; // 방향 전환
                continue;
            }

            if (isRotate){
                if (deque.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        // 남은 덱의 요소들을 출력하는 함수 호출
        printDeque(deque , isRotate);
    }

    public static void printDeque(ArrayDeque<Integer> deque , boolean isRotate){
        sb.append("[");

        if (deque.size() >0) {
            if (isRotate){ // 정방향
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else { // 역방향
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");
    }


}