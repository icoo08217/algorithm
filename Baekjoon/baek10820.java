
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String input;

        while((input = br.readLine()) != null){
            sb = new StringBuilder();

            int so = 0;
            int dae = 0;
            int num = 0;
            int space = 0;

            for (int i=0; i<input.length(); i++){
                char c = input.charAt(i);
                if (c >= 'a' && c <= 'z') so++;
                else if (c >= 'A' && c <= 'Z') dae++;
                else if (c >= '0' && c <= '9') num++;
                else space++;

            }

            sb.append(so + " ").append(dae + " ").append(num + " ").append(space);
            System.out.println(sb);
        }

    }
}


