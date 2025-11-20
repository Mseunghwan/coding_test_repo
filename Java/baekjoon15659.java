import java.util.*;
import java.io.*;

public class baekjoon15659 {
    static int N;

    static int max_rs = Integer.MIN_VALUE;
    static int min_rs = Integer.MAX_VALUE;
    static int[] nums;

    // 덩어리를 키우는 방식으로 가자
    static void DFS(int[] itertool, int now, int sum, int prev){
        
        if(now == N){
            sum += prev;
            if(sum > max_rs){
                max_rs = sum;
            }
            if(sum < min_rs){
                min_rs = sum;
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            if(itertool[i] > 0){
                if(i == 0){
                    itertool[i] -= 1;
                    DFS(itertool, now + 1, sum + prev, nums[now]);
                    itertool[i] += 1;
                } else if(i == 1){
                    itertool[i] -= 1;
                    DFS(itertool, now + 1, sum + prev, -nums[now]);
                    itertool[i] += 1;
                } else if(i == 2){
                    itertool[i] -= 1;
                    DFS(itertool, now + 1, sum, prev * nums[now]);
                    itertool[i] += 1;
                } else if(i == 3){
                    itertool[i] -= 1;
                    DFS(itertool, now + 1, sum, prev / nums[now]);
                    itertool[i] += 1;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        int[] itertool = new int[4];
        for(int i = 0; i < 4; i++){
            itertool[i] = Integer.parseInt(st.nextToken());
        }

        DFS(itertool, 1, 0, nums[0]);


        bw.write(String.valueOf(max_rs) + "\n");
        bw.write(String.valueOf(min_rs));

        bw.flush();
        bw.close();
        br.close();
    }
}
