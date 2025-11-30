import java.io.*;
import java.util.*;

public class baekjoon2230 {
    static int[] A;
    static int min_rs = Integer.MAX_VALUE;

    static int N;
    static int M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N];

        for(int i = 0 ; i< N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
 
        // 투 포인터로 접근
        int start = 0;
        int end = start + 1;
        while(end < N){

            int val = A[end] - A[start];

            // 만약 M 보다 작으면 키워주고
            if(val < M){
                end ++;
            } else {
                // M보다 같거나 크면
                if(val < min_rs){
                    // 갱신
                    min_rs = val;
                }
                // 그리고 줄여주기
                start ++;
                
                // 만약 같다면 더 작아질 수 없으므로 바로 break;
                if(val == M) break;
            }

        }

        bw.write(String.valueOf(min_rs));
        bw.flush();
        bw.close();
        br.close();


    }
}
