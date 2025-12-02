import java.util.*;
import java.io.*;

// DP식 사고 어렵다,, 알거 같으면서도 모르겠고 하하
public class baekjoon12852 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());

        // N을 1로 만드는 최소 횟수? N에서 갈 수 있는 다음 단계들 중 가장 횟수가 적은 곳에서 +1을 한 것과 동일하다
        
        int[] dp = new int[X + 1];

        // 이전 경로 확인하는
        int[] where = new int[X + 1];
        dp[0] = 0;
        dp[1] = 0;

        // 1에서 X까지 간다고 가정

        for(int i = 2; i <= X; i++){
            
            // 첫 번째, 그냥 -1의 경우
            dp[i] = dp[i - 1] + 1;
            where[i] = i - 1;

            // 두 번째, 2로 나누어 떨어 지고 /2 한 경우보다 더 크다면
            if(i % 2 == 0 && dp[i] > dp[i / 2] + 1){
                dp[i] = dp[i / 2] + 1;
                where[i] = i / 2;
            }
            
            // 세 번째, 3로 나누어 떨어 지고 /3 한 경우보다 더 크다면
            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1){
                dp[i] = dp[i / 3] + 1;
                where[i] = i / 3;
            }
        }

        
        StringBuilder sb = new StringBuilder();

        sb.append(X + " ");
        int now = X;
        
        while(now != 1){
            sb.append(where[now] + " ");
            now = where[now];
        }
        System.out.println(dp[X]);
        System.out.println(sb);

    }
}
