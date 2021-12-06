import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++){
            sb.append(arr[i]+ " ");
        }

        System.out.print(sb);


    }
}
