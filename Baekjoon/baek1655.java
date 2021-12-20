

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(((o1, o2) -> o1 - o2));

        for (int i=0; i<N; i++){
            int t = Integer.parseInt(br.readLine());

            if (maxPQ.size() == minPQ.size()){
                maxPQ.offer(t);
            }
            else {
                minPQ.offer(t);
            }

            if (!maxPQ.isEmpty() && !minPQ.isEmpty()){
                if (minPQ.peek() < maxPQ.peek()){
                    int tmp = minPQ.poll();
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(tmp);
                }
            

            }
            sb.append(maxPQ.peek() + "\n");

        }

        System.out.println(sb);


    }
}
