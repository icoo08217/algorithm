package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Baek1251 {

    static ArrayList<String> list = new ArrayList<>();
    static StringBuffer sbf;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String[] str = new String[3];

        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                //substring으로 문자열을 세부분으로 자르기
                str[0] = word.substring(0, i);
                str[1] = word.substring(i, j);
                str[2] = word.substring(j, word.length());
                sb = new StringBuilder();

                // 쪼개진 문자열들 뒤집기
                for (int k = 0; k < str.length; k++) {
                    sbf = new StringBuffer(str[k]);
                    String reversed = sbf.reverse().toString();
                    sb.append(reversed);
                }
                String addStr = sb.toString();
                list.add(addStr);
            }
        }
        Collections.sort(list); // 정렬
        bw.write(list.get(0));
        bw.flush();
        bw.close();
    }
}
