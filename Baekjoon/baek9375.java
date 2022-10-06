import java.util.*;
import java.io.*;

public class baek9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            HashMap<String , Integer> fashion = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine() ," ");
                st.nextToken();
                String kind = st.nextToken();
                if (fashion.containsKey(kind)){
                    fashion.put(kind , fashion.get(kind) + 1);
                } else {
                    fashion.put(kind, 1);
                }
            }
            int result = 1;
            for (int val : fashion.values()) {
                result *= (val+1);
            }
            System.out.println(result - 1);
        }
    }

}
