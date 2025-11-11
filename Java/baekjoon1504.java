import java.util.*;
import java.io.*;

public class baekjoon1504 {
	
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
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 거쳐서 가는 dijkstra
		// 두 거리 중 가까운 순으로 먼저 방문
		// N이 4일때, 1 -> 2 -> 3 -> 4 순으로 방문
		// 어차피 두 개 니까, 각각의 경우를 dijkstra 하는 걸로
		// dist_1 --> 첫 번째 경우 선택하는
		// dist_2 --> 두 번째 경우 선택하는
		// dist_3 --> 마지막 경우 위치에서 N까지의 거리
		// sum_1 --> 첫 정점 먼저 선택한 경우, sum_2 --> 두 번째 정점 먼저 선택한 경우
		// 두 개 비교해서 작은걸 답으로, 만약 INF 라면 -1 출력
		
		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Node(e, w));
			graph[e].add(new Node(s, w));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		int must_visit_1 = Integer.parseInt(st.nextToken());
		int must_visit_2 = Integer.parseInt(st.nextToken());
		
		int[] dist_1 = new int[N + 1];
		Arrays.fill(dist_1, INF);
		dist_1[1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(1, 0));
		
		long sum_1 = 0;
		long sum_2 = 0;
		
		// dijkstra
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int now_v = now.v;
			int now_w = now.w;
			
			if(now_w > dist_1[now_v]) {
				continue;
			}
			
			for(Node next : graph[now_v]) {
				if(dist_1[next.v] > dist_1[now_v] + next.w) {
					dist_1[next.v] = dist_1[now_v] + next.w;
					pq.add(new Node(next.v, dist_1[next.v]));
				}
			}
		}
		// 처음 노드 부터 방문
		sum_1 += dist_1[must_visit_1];
		// 해당 노드로 이동 후 둘째 노드로 가기
		int[] dist_2 = new int[N + 1];

		Arrays.fill(dist_2, INF);
		dist_2[must_visit_1] = 0;
		pq = new PriorityQueue();
		pq.add(new Node(must_visit_1, 0));
		
		// dijkstra
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int now_v = now.v;
			int now_w = now.w;
			
			if(now_w > dist_2[now_v]) {
				continue;
			}
			
			for(Node next : graph[now_v]) {
				if(dist_2[next.v] > dist_2[now_v] + next.w) {
					dist_2[next.v] = dist_2[now_v] + next.w;
					pq.add(new Node(next.v, dist_2[next.v]));
				}
			}
		}
		sum_1 += dist_2[must_visit_2];
		
		// 마지막(둘 째) 노드에서 마지막 N으로 이동
				int[] dist_3 = new int[N + 1];

				Arrays.fill(dist_3, INF);
				dist_3[must_visit_2] = 0;
				pq = new PriorityQueue();
				pq.add(new Node(must_visit_2, 0));
				
				// dijkstra
				while(!pq.isEmpty()) {
					Node now = pq.poll();
					int now_v = now.v;
					int now_w = now.w;
					
					if(now_w > dist_3[now_v]) {
						continue;
					}
					
					for(Node next : graph[now_v]) {
						if(dist_3[next.v] > dist_3[now_v] + next.w) {
							dist_3[next.v] = dist_3[now_v] + next.w;
							pq.add(new Node(next.v, dist_3[next.v]));
						}
					}
				}
		sum_1 += dist_3[N];
		
		// 둘째 노드 부터 방문
		sum_2 += dist_1[must_visit_2];
		
		// 둘째 노드에서 첫 째 노드로 이동
		sum_2 += dist_3[must_visit_1];
		// 첫 째 노드에서 마지막 노드로 이동
		sum_2 += dist_2[N];
		
		long rs = 0;
		if(sum_1 > sum_2) {
			rs = sum_2;
		} else {
			rs = sum_1;
		}
		
		if(rs >= INF) {
			bw.write("-1"); 
		}else {
			bw.write(String.valueOf(rs));
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
		
		
	}
}
