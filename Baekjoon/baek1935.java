import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Double> stk = new Stack<>();
        char c = 'A';

        for(int i=0; i<N; i++){
            map.put((char)(c + i), Integer.parseInt(br.readLine()));
        }

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if ( ch >= 'A' && ch <='Z'){
                stk.push((double)map.get(ch));
            }
            else {
                double b = stk.pop();
                double a = stk.pop();

                switch (ch){
                    case '+':
                        stk.push(a + b);
                        break;

                    case '-':
                        stk.push(a - b);
                        break;

                    case '*':
                        stk.push(a * b);
                        break;

                    case '/':
                        stk.push(a / b);
                        break;
                }
            }
        }
        System.out.printf("%.2f" , stk.pop());
    }
}