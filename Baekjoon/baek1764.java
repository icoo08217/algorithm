import java.util.*;
import java.io.*;

class baek1764{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i=0; i<N; i++){
            String d = br.readLine();
            set.add(d);
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i=0; i<M; i++){
            String bo = br.readLine();
            if (set.contains(bo)){
                answer.add(bo);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }


    }
}