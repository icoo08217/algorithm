import java.util.*;
import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> doGam = new HashMap<>();
        String doGamString[] = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String pocketMon = br.readLine();
            doGam.put(pocketMon , i);
            doGamString[i] = pocketMon;
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if(isNumber(quiz)) {
                int index = Integer.parseInt(quiz);
                sb.append(doGamString[index]);
            } else {
                sb.append(doGam.get(quiz));
            }
            sb.append("\n");
        }

        System.out.println(sb);


        }

    static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}