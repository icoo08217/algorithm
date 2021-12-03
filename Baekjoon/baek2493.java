import java.io.*;
import java.util.*;

class Top{
    int topNum;
    int topHeight;

    Top(int topNum , int topHeight){
        this.topNum = topNum;
        this.topHeight = topHeight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()){
                result.append("0 ");
                stack.push(new Top(i, height));
            } else {
                while(true){
                    if (stack.isEmpty()){
                        result.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    Top top = stack.peek();

                    if (top.topHeight > height){
                        result.append(top.topNum + " ");
                        stack.push(new Top(i, height));
                        break;
                    } else stack.pop();
                }
            }
        }
        System.out.println(result);

    }

}