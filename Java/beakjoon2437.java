import java.util.*;
import java.io.*;

public class beakjoon2437 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] choo = new int[N];
        for(int i = 0 ; i < N; i ++){
            choo[i] = Integer.parseInt(st.nextToken());
        }

        // 콜롬버스의 달걀
        Arrays.sort(choo);
        int sum = 0;
        for(int i = 0 ; i < N; i++){
            if(sum + 1 < choo[i]){
                break;
            }
            sum += choo[i];
        }

        bw.write(String.valueOf(sum + 1));

        bw.flush();
        bw.close();
        br.close();

    }
}
