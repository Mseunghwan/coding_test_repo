import java.util.*;
import java.io.*;

public class baekjoon2467 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터로 풀기
        Arrays.sort(nums);

        int start = 0;
        int end = N - 1;


        int min_diff = Integer.MAX_VALUE;
        int min_start = 0;
        int min_end = 0;

        while(start < end){
            int sum = nums[end] + nums[start];
            
            if(Math.abs(sum) < min_diff){
                min_diff = Math.abs(sum);
                min_start = start;
                min_end = end;
            }

            if(sum < 0) {
                start ++;
            } else if(sum > 0){
                end --;
            } else {
                min_start = start;
                min_end = end;
                break;
            }
        }

        bw.write(String.valueOf(nums[min_start]) + " " + String.valueOf(nums[min_end]));
        bw.flush();
        bw.close();
        br.close();

    }
}
