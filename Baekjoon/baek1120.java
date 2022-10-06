
import java.io.*;
import java.util.StringTokenizer;

public class baek1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int result = A.length();
        int diff = B.length() - A.length();

        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int temp = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j+i)){
                    temp++;
                }
            }
            if (result > temp) {
                result = temp;
            }
        }
        System.out.println(result);
    }
}
