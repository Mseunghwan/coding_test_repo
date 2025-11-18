import java.io.*;
import java.util.*;

public class baekjoon1719 {
	
//	public class Node{
//		int w;
//		int next;
//		
//		Node(int w, int next){
//			this.w = w;
//			this.next = next;
//		}
//	}
	
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		// 집하장 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 노드 = w, next 경로 저장하도록 이를 활용해 graph 2차원 배열 선언 해서 풀어도 되고
		// 경로저장 graph 하나 만들어서 거기를 갱신하는 방식으로 풀어도 되는데
		// 쉽게 가기 위해 경로저장 graph로 가자
		
		// 비용 그래프
		int[][] graph = new int[N + 1][N + 1];
		int[][] next_graph = new int[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
			Arrays.fill(next_graph[i], 0);
		}
		
		for(int i = 0; i <= N; i++) {
			graph[i][i] = 0;
			next_graph[i][i] = INF;
		}
		
		// 집하장 간 경로
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
			graph[b][a] = c;
			next_graph[a][b] = b;
		next_graph[b][a] = a;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int a = 1; a <= N; a++) {
				for(int b = 1; b <= N; b++) {
					if(graph[a][k] != INF && graph[k][b] != INF) {
					
					if(graph[a][b] > graph[a][k] + graph[k][b]) {
						graph[a][b] = graph[a][k] + graph[k][b];
						// 먼저 가야 할 경로를 할당
						next_graph[a][b] = next_graph[a][k];
				}	
					}
				}
			}	
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					bw.write("- ");
				}else {
				bw.write(String.valueOf(next_graph[i][j]) + " ");
			}
				}
			bw.write("\n");
		}
		

		bw.flush();
		bw.close();
		br.close();
		
	}
}
