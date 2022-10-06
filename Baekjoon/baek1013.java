import java.util.*;
import java.io.*;

class baek1013 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            String str = br.readLine();
            String pattern = "(100+1+|01)+";
            System.out.println(str.matches(pattern)? "YES" : "NO");
        }
    }
}