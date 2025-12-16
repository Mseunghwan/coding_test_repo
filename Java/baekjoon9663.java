import java.io.*;
import java.util.*;

public class baekjoon9663 {
    static int N ;
    static int rs = 0;

    static int[] maps;

    static boolean check(int depth){
        boolean flag = true;
        
        for(int i = 0 ; i < depth; i++){
            if(maps[i] == maps[depth] || Math.abs(maps[i] - maps[depth]) == Math.abs(i - depth)){
                flag = false;
                break;
            }
        }

        return flag;
    }
    static void BackTracking(int depth){
        if (depth == N){
            rs++;
            return;
        }

        for(int i = 0; i < N; i++){
            maps[depth] = i;
            if(check(depth)){
                BackTracking(depth + 1);
            }
        }
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());


        maps = new int[N];
        Arrays.fill(maps, 0);
        
        BackTracking(0);

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();
    }
}
