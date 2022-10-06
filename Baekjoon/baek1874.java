import java.util.*;
import java.io.*;

class baek1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        for (int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int j = start + 1; j<=value; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = value;
            }

            else if (stack.peek() != value){
                System.out.print("NO");
                System.exit(0); // return 과 같은 의미
            }

            stack.pop();
            sb.append("-").append("\n");

        }

        System.out.println(sb);

    }
}