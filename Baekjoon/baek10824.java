
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        long num1 = Long.parseLong(s[0] + s[1]);
        long num2 = Long.parseLong(s[2] + s[3]);

        sb.append(num1 + num2);

        System.out.println(sb);

        
    }
}