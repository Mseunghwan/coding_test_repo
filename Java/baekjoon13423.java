import java.util.*;
import java.io.*;

public class baekjoon13423 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int c = 0; c < tc; c++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            // 두 점 a, b 잡고, 나머지 점 c 잡기
            // 즉, diff = a - b 이렇게 잡으면
            // c = b + diff
            // 이게 되는 경우를 찾아보는 거다
            int rs = 0;
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    // 간격 체크
                    int diff = arr[j] - arr[i];
                    // 찾아야 할 값 체크
                    int to_find = arr[j] + diff;

                    // 찾으면 인덱스 반환, 없으면 음수
                    if(Arrays.binarySearch(arr, to_find) >= 0){
                        rs += 1;
                    }
                }
            }

            bw.write(String.valueOf(rs) + "\n");        
        }
    bw.flush();
    bw.close();
    br.close();
    }
}
