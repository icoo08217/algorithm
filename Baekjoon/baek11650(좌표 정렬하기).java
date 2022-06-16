import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dot[] arr = new dot[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dotX = Integer.parseInt(st.nextToken());
            int dotY = Integer.parseInt(st.nextToken());
            arr[i] = new dot(dotX, dotY);
        }

        Arrays.sort(arr, new Comparator<dot>() {
            @Override
            public int compare(dot o1, dot o2) {
                if( o1.getX() == o2.getX()){
                    return o1.getY() - o2.getY();
                } else {
                    return o1.getX() - o2.getX();
                }
            }
        });

        for (dot dot : arr) {
            System.out.println(dot.getX() + " "+ dot.getY());
        }


    }

    static class dot{
        int x;
        int y;

        public dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }
    }
}
