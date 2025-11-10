import java.util.*;
import java.io.*;

public class problem1753 {
    // 인접리스트로 받기 위함
    static class Node implements Comparable<Node>{
        int v; // 도착지 노드
        int w; // 가중치

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        // 우선순위 큐를 위한 정렬 기준
        @Override
        public int compareTo(Node o) {
            return this.w - o.w; // 오름차순
        }
    }

    // 무한대 값 설정
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        // 인접 리스트 구현
        ArrayList<Node>[] graph = new ArrayList[V + 1];

        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        // 최단거리배열 초기화
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작노드 설정
        dist[k] = 0;
        pq.add(new Node(k, 0));

        // 다익스트라 시작
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cur_w = cur.w;
            int cur_v = cur.v;

            if(dist[cur_v] < cur_w){
                continue;
            }

            for(Node next : graph[cur_v]){
                int next_w = next.w;
                int next_v = next.v;

                if(dist[next_v] > dist[cur_v] + next_w){
                    dist[next_v] = dist[cur_v] + next_w;
                    pq.add(new Node(next_v, dist[next_v]));
                }
            }

        }

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                bw.write("INF\n");

            }else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
