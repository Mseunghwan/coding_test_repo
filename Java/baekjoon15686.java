import java.util.*;
import java.io.*;

public class baekjoon15686 {
    static int N;
    static int M;

    static class Node {
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }

    }

    static ArrayList<Node> KFC;
    static ArrayList<Node> homes;

    static int min_val = Integer.MAX_VALUE;
    
    public static void BackTracking(int depth, int start, Node[] kfcs){
        // 종료조건
        if(depth == M){
            int sum = 0;
            for(Node home : homes){

                int min_now = Integer.MAX_VALUE;

                for(Node chic : kfcs){
                    int val = Math.abs(home.y - chic.y) + Math.abs(home.x - chic.x);
                    if(val < min_now){
                        min_now = val;
                    }
                }
                sum += min_now;
            }
            if(sum < min_val){
                min_val = sum;
            }
            return;
        }
        for(int i = start ; i < KFC.size(); i++){
            kfcs[depth] = KFC.get(i);

            BackTracking(depth + 1, i + 1, kfcs);
        }

    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        KFC = new ArrayList<>();
        
        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1) {
                    homes.add(new Node(i, j));
                }
                else if(val == 2){
                    KFC.add(new Node(i, j));
                }
            }
        }
        
        // 0은 빈 칸, 1은 집, 2는 치킨 집
        // 집 개수는 1개 이상은 존재, 2N 넘지 않는다
        // 치킨 집 개수는 M 보다 크거나 같고, 13보다 작거나 같다
        // 치킨거리 --> 집과 가장 가까운 치킨집 사이의 거리
        // 도시의 치킨거리 --> 모든 집의 치킨거리의 합
        // 가장 수익을 많이 낼 수 있는 치킨 집 개수는 M개
        // 최대 M개를 고르고 나머지는 모두 폐업시켜야, 
        // 어떻게 해야 치킨 거리가 가장 적게 될 지 구하는 문제
        // 치킨 집 위치를 고르는 경우의 수를 만들어서
        // 각 위치에서 연산
        
        Node[] kfcs = new Node[M];
        BackTracking(0, 0, kfcs);
        bw.write(String.valueOf(min_val));

        bw.flush();
        bw.close();
        br.close();

    }
}
