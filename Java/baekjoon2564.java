import java.util.*;
import java.io.*;

public class baekjoon2564 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 선형으로 생각해서 보자.
        
        str = br.readLine();
        st = new StringTokenizer(str, " ");

        int n = Integer.parseInt(st.nextToken());

        int dir;
        int dist;

        // 가게들 위치 (1차원 평면으로 생각해서)
        int[] distances = new int[n];

        for(int i = 0 ; i < n ; i ++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            // 방향
            dir = Integer.parseInt(st.nextToken());
            // 거리
            dist = Integer.parseInt(st.nextToken());

            distances[i] = getPosition(dir, dist, w, h);
        }

        // 동근이 위치
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        // 방향
        dir = Integer.parseInt(st.nextToken());
        // 거리
        dist = Integer.parseInt(st.nextToken());

        int dongs = getPosition(dir, dist, w, h);

        // 각 상점들 까지의 최단 거리 합
        int sum = 0;
        // 전체 길이
        int length = (2 * w) + (2 * h);

        for(int i = 0 ; i < n; i ++){
            // 시계방향
            int clock = Math.abs(distances[i] - dongs);
            // 반시계방향
            int nonclock = Math.abs(length - clock);

            // 최단거리 합에 작은 거 넣어주기
            sum += Math.min(clock, nonclock);
        }

        System.out.printf("%d", sum);





        

    }

    public static int getPosition(int dir, int dist, int w, int h){

        if(dir == 1) {
            // 북쪽이라면
            return dist;
        } else if(dir == 2){
            // 남쪽이라면
            return w + h + (w - dist);
        }else if(dir == 3){
            // 서쪽이라면
            return 2 * w + h + (h - dist);
        }else if(dir == 4){
            // 동쪽이라면
            return w + dist;
        }

        return 0;
    }
}
