
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++){
            q.add(i);
        }

        while (true){
            if (q.size() == 1){
                break;
            }
            q.remove();
            q.add(q.peek());
            q.remove();

        }
        System.out.println(q.peek());

    }
}
