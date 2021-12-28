
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int w = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken());

        Queue<Integer> truck = new LinkedList<>();

        str = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            truck.offer(Integer.parseInt(str.nextToken()));
        }

        int time = 0;
        int bw = 0; // Bridge Weight

        Queue<Integer> bridge = new LinkedList<>(); // 다리위를 큐로 선언

        // 다리의 길이만큼 0을 넣어준다.
        for (int i=0; i<w; i++){
            bridge.add(0); // offer() 와 add() 차이를 알 필요가 있다.
        }

        while (!bridge.isEmpty()){
            time++;
            bw -= bridge.poll();
            if (!truck.isEmpty()){
                if (bw + truck.peek() <= L){
                    bw += truck.peek();
                    bridge.offer(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(time);

    }
}