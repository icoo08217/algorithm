import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result =0;

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if (c == '('){
                stack.push(c);
                continue;
            }

            if (c == ')'){
                stack.pop();
                if (input.charAt(i-1) == '('){ // 레이저라는 뜻임.
                    result += stack.size();
                } else // ')' 라면 한 막대기의 끝을 의미하는 것이다.
                    result += 1;
            }
        }

        System.out.println(result);
    }
}


