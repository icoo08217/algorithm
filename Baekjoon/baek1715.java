import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o1-o2)); // minheap이 이게 맞는가 확인하기
        // minheap => new PriorityQueue<>(((o1, o2) -> o1 - o2))
        
        
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            ans = ans + x + y;
            pq.offer(x+y);
        }
        System.out.println(ans);


    }
}