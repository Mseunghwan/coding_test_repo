import java.io.*;
import java.util.*;
public class baekjoon1238 {

	static class Node implements Comparable<Node>{
		int v;
		int w; 
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;	
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 마을 사이 도로 개수(단방향)
		int X = Integer.parseInt(st.nextToken()); // 파티하는 마을의 번호
		
		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for(int i = 0; i <= N; i ++) { 
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, t));
		}
		
		// 각 학생들의 위치에서 마을로 갔다가, 돌아가는 것 계산해서 저장해서 그 중 가장 큰 값 가져오기
		// 학생들의 dist 값 sum 저장하는 array
		int[] dists = new int[N + 1];
		int[] dist;
		PriorityQueue<Node> pq;
		// 갈 때
		for(int i = 1; i < N + 1; i ++) {
			dist = new int[N + 1];
			Arrays.fill(dist, INF);
			dist[i] = 0;
			pq = new PriorityQueue();
			pq.add(new Node(i, 0));
			
			// dijkstra 시작
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				int now_v = now.v;
				int now_w = now.w;
				
				if(dist[now_v] < now_w) {
					continue;
				}
				
				for(Node next : graph[now_v]) {
					if(dist[next.v] > dist[now_v] + next.w) {
						dist[next.v] = dist[now_v] + next.w;
						pq.add(new Node(next.v, dist[next.v]));
					}
				}	
			}
			dists[i] += dist[X];
		}
		
		// 올 때
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		pq = new PriorityQueue();
		pq.add(new Node(X, 0));
			
		// dijkstra 시작
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int now_v = now.v;
			int now_w = now.w;
				
			if(dist[now_v] < now_w) {
				continue;
			}
				
			for(Node next : graph[now_v]) {
				if(dist[next.v] > dist[now_v] + next.w) {
					dist[next.v] = dist[now_v] + next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}	
		}
		for(int i = 1; i <= N; i++) {
			dists[i] += dist[i];
		}
		
		long max_val = 0;
		for(int i = 1; i <= N; i++) {
			if(dists[i] < INF   && dists[i] > max_val) {
				max_val = dists[i];
			}
		}
		
		bw.write(String.valueOf(max_val));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
