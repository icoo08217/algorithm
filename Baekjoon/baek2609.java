
import java.util.*;
import java.io.*;

class baek2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a,b));
        System.out.println(a * b / gcd(a,b));
    }

    public static int gcd(int a, int b){
        if( a > b){
            if (b == 0) return a;
            return gcd(b , a%b);
        }
        else {
            if (a == 0) return b;
            return gcd(a , b%a);
        }
    }
}


