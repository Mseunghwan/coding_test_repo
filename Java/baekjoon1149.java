import java.util.*;
import java.io.*;

public class baekjoon1149 {
    static int N;

    static int[][] maps;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        maps = new int[N][3];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp로 해결
        int[][] dp = new int[N][3];

        dp[0][0] = maps[0][0];
        dp[0][1] = maps[0][1];
        dp[0][2] = maps[0][2];
        for(int i = 1 ; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + maps[i][0]; 
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + maps[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + maps[i][2];
        }
        int rs = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i++){
            if(dp[N - 1][i] < rs) {
                rs = dp[N - 1][i];
            }
        }
        bw.write(String.valueOf(rs)); 
        bw.flush();
        bw.close();
        br.close();

    }
}
