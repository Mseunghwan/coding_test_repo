import java.util.*;
import java.io.*;

public class baekjoon17298 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // int[] nums = new int[N];
        

        // 오큰수(NGE) 문제
        // 특정 수 a 의 오른쪽에 있으면서 a 보다 큰 수 중 가장 왼쪽에 있는 수를 의미한다
        // 그러한 수가 없는 경우엔 -1를 출력해야 하는 문제
        // 만약 nums = [3, 5, 2, 7] 일 떼
        // NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1
        // 일반 반복문(아래) 시간 터짐
        // for(int i = 0; i < N; i++){ 
        //     boolean flag = true;
        //     for(int j = i + 1; j < N; j++){
        //         if(nums[j] > nums[i]){
        //             bw.write(nums[j] + " ");
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag){
        //         bw.write("-1 ");
        //     }
        // }

        int[] nums = new int[N];


        // 스택 활용해 풀기
        Stack<Integer> stack = new Stack<>();
        
        // 정답 출력 용
        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        for(int i = 0 ; i < N; i++){
            // 들어오는 값
            nums[i] = Integer.parseInt(st.nextToken());
            // 만약 스택에 값이 있고, 지금 값이 스택 마지막 값보다 크면
            while(!stack.empty() && nums[i] > nums[stack.peek()]) {
                // 스택 인덱스가 가리키는 NGE는 지금 들어오는 값이다, while 계속 돌아주기
                int index = stack.pop();
                answer[index] = nums[i];
            }
            // 끝나면 현재 들어온 값을 스택에 넣어주기
            stack.push(i);
        }

        for(int i = 0 ; i < N; i++){
            bw.write(String.valueOf(answer[i]) + " ");
        }


        bw.flush();
        bw.close();
        br.close();



    }    
}
