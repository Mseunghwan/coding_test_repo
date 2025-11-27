import java.io.*;
import java.util.*;

public class baekjoon12865 {
    static class Thing implements Comparable<Thing> {
        int w;
        int v;

        Thing(int w, int v){
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Thing other){
            return this.w - other.w;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Thing[] things = new Thing[N];

        int K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            things[i] = new Thing(w, v);
        }


        // for(int i = 0 ; i < N; i++){
        //     int w = things[i].w;
        //     int v = things[i].v;
        //     bw.write(String.valueOf(w) + " ");
        //     bw.write(String.valueOf(v) + "\n");
        // }

        // DP 로 풀기
        // 각 무게까지 가치를 담아주는 DP
        int[] DP = new int[K + 1];

        Arrays.sort(things);

        for(int i = 0; i < N; i++){
            int w = things[i].w;
            int v = things[i].v;

            for(int j = K; j >= w; j--){
                DP[j] = Math.max(DP[j], DP[j - w] + v);
            }
        }
        bw.write(String.valueOf(DP[K]));

        bw.flush();

        bw.close();
        br.close();
        
    }
}
