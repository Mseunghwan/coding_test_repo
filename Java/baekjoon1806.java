import java.util.*;
import java.io.*;

public class baekjoon1806 {
    static int N;
    static int S;
    static int[] nums;
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        
        int min_rs = Integer.MAX_VALUE;

        int total = 0;
        
        while(true) {
            // S 보다 크면
            if(total >= S){
                min_rs = Math.min(min_rs, end - start);
                // 한번 빼보기

                total -= nums[start];
                start ++;
            }    
            else if(end == N){
                break;
            } else {
                total += nums[end];
                end ++;
            }

        }

        if(min_rs == Integer.MAX_VALUE){
            bw.write(String.valueOf(0));    
        } else {
        bw.write(String.valueOf(min_rs));
        }

        bw.flush();
        bw.close();
        br.close();
        
    }
}
