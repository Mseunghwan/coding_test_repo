import java.util.*;
import java.io.*;

public class problem1916 {

    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

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
        bw.write(String.valueOf(dist[e]));
        bw.flush();
        bw.close();
        br.close();

    }
}
