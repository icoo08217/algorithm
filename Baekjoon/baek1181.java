import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            arr[i] = temp;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()){ // 길이가 같다면 사전순으로 정렬하여야 한다.
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        System.out.println(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
        }
    }
}
