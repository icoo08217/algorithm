import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        String a="";
        while (queue.size() != 1){
            a += queue.poll().toString() + " ";
            queue.add(queue.poll());
        }
        System.out.println(a + queue.poll());


    }
}