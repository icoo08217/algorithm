import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack;
    static int result = 0;
    static int temp = 1;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        stack = new Stack<Integer>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') { // 여는 괄호 '('
                stack.add(2);
                temp *= 2;
            } else if (input.charAt(i) == '[') { // 여는 괄호 '['
                stack.add(3);
                temp *= 3;
            } else { // 닫는 괄호
                if (stack.size() == 0) // 여는 괄호가 없음.
                {
                    result = 0;
                    break;
                }
                // 다른 것이 들어옴.
                if (input.charAt(i) != ')' && input.charAt(i) != ']') {
                    result = 0;
                    break;
                }
                // 짝이 안맞음.
                if ((input.charAt(i) == ')' && stack.peek() == 3) || (input.charAt(i) == ']' && stack.peek() == 2)){
                    result = 0;
                    break;
                }
                //
                int cur=2;
                if( input.charAt(i) ==']') {
                    cur=3;
                }

                if( stack.size()==0 || (input.charAt(i-1)=='(' && cur==2) || (input.charAt(i-1)=='[' && cur==3)) {
                    result += temp;
                }

                stack.pop();
                temp /= cur;
            }
        }
        if (stack.size() != 0) {
            result = 0;
        }
        System.out.println(result);
    }
}
