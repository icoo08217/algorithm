
import java.util.*;
import java.io.*;

class baek11655{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int temp;

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if (c >= 65 && c <= 90) { // 'A' ~ 'Z' 일 경우
                temp = c + 13;
                if (temp >90) {
                    temp = temp - 'Z' + 'A' - 1;
                    sb.append((char)temp);
                } else {
                    sb.append((char)temp);
                }
            }
            else if (c >= 'a' && c <= 'z'){ // 'a' ~ 'z' 일 경우
                temp = c + 13;
                if (temp > 'z'){
                    temp = temp - 'z' + 'a' - 1;
                    sb.append((char)temp);
                } else {
                    sb.append((char)temp);
                }
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);


    }
}