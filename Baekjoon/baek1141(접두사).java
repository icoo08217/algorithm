import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            word[i] = input;
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String origin = word[i];
            int count = 0;
            for (int j = 0; j < N; j++) {
                if( i != j) {
                    String comp = word[j];
                    if( origin.length() <= comp.length()) {
                        if (!comp.startsWith(origin)){
                            count++;
                        } else if(comp.equals(origin)){
                            count++;
                        }
                    } else {
                        count++;
                    }
                }
            }
            if (count == N-1){
                result.add(origin);
            }
        }
        System.out.println(result.size());


    }

}
