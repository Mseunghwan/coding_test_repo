import java.util.*;
import java.io.*;

public class baekjoon14888 {
    static int N;

    static int max_val = Integer.MIN_VALUE;
    static int min_val = Integer.MAX_VALUE;
    static int[] nums;

    static void DFS(int depth, int[] methods, int sum){
        
        // 종료 조건, 마지막 값 까지 왔다면 sum 으로 갱신 후 리턴
        if(depth == N){
            if(sum > max_val){
                max_val = sum;
            }
            if(sum < min_val){
                min_val = sum;
            }
            return;
        }

        for(int i = 0 ; i < 4; i ++){
            if(methods[i] > 0){
                methods[i] -= 1;
                if(i == 0){
                    // 덧셈
                    DFS(depth + 1, methods, sum + nums[depth]);

                } else if(i == 1){
                    // 뺄셈
                    DFS(depth + 1, methods, sum - nums[depth]);

                } else if(i == 2){
                    // 곱셈
                    DFS(depth + 1, methods, sum * nums[depth]);

                } else if(i == 3){
                    if(sum < 0){
                        int val = -sum;
                        int go = val / nums[depth];
                        DFS(depth + 1, methods, -go);
                    } else {
                    // 나눗셈
                    DFS(depth + 1, methods, sum / nums[depth]);
                }   
                }
                methods[i] += 1;
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

        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] methods = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < 4; i++){
            methods[i] = Integer.parseInt(st.nextToken());
        }

        // 우선, 숫자를 돌면서 BackTracking 하는 문제
        // 연산자 개수가 있는 걸 확인하고 만약 있으면 그 경우를 가보는,
        DFS(1, methods, nums[0]);

        bw.write(String.valueOf(max_val) + "\n");
        bw.write(String.valueOf(min_val));
    
        bw.flush();
        bw.close();
        br.close();



    }
}
