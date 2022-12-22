package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int scene = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                return;
            } else {
                scene++;
            }

            ArrayList<String> students = new ArrayList<String>();

            for (int i = 0; i < n; i++) {
                students.add(br.readLine());
            }

            ArrayList<Integer> isNum = new ArrayList<Integer>();
            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (isNum.contains(num)) {
                    isNum.remove((Integer) num);
                } else {
                    isNum.add(num);
                }
            }

            int answer = isNum.get(0);
            System.out.println(scene + " " + students.get(answer - 1));
        }
    }
}

