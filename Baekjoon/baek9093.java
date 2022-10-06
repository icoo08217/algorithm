import java.util.*;
import java.io.*;

class baek9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        Stack<Character> word = new Stack<>();

        for(int i=0; i<T; i++){
            String s = br.readLine() + "\n";
            for (char c : s.toCharArray()) {
                if (c == ' ' || c == '\n'){
                    while (!word.isEmpty()){
                        bw.write(word.pop());
                    }
                    bw.write(c);
                }

                else {
                    word.push(c);
                }
            }
        }
        bw.flush();
    }
}