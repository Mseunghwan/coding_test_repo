import java.util.*;
import java.io.*;

public class baekjoon2467 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());

        int[] items = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items);

        int start = 0;
        int end = N - 1;

        int min_left = 0;
        int min_right = 0;
        int min_val = Integer.MAX_VALUE;

        while(start < end){
            int val = items[start] + items[end];
            if(Math.abs(val) < min_val) {
                min_val = Math.abs(val);
                min_left = start;
                min_right = end;
            }
            if(val < 0){
                start ++;
            } else if(val > 0){
                end --;
            } else {
                min_left = start;
                min_right = end;
                break;
            }
        }

        bw.write(String.valueOf(items[min_left]) + " " + String.valueOf(items[min_right]));
        bw.flush();
        bw.close();
        br.close();

    }
}
