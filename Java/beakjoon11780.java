import java.util.*;
import java.io.*;

public class beakjoon11780 {
	static int INF = 100_000_001;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 도시 개수
		int N = Integer.parseInt(br.readLine());
		// 버스 개수
		int M = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[N + 1][N + 1];
		
		// 갈 경로를 가리키는 next[][] 생성
		int[][] next = new int[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(next[i], 0);
		}
//		// 지나온 경로를 담는 ArrayList 생성 --> 하면,, 터진다
//		ArrayList<ArrayList>[] history = new ArrayList[N + 1];
//		
//		for(int i = 1; i <= N; i++) {
//
//			ArrayList val = new ArrayList();
//			for(int j = 1; j <= N; j++) {
//				if(i == j) {
//					ArrayList val_son = new ArrayList();
//					val_son.add(INF);
//					val.add(val_son);
//				} else {
//				ArrayList val_son = new ArrayList();
//				val_son.add(i);
//				val.add(val_son);
//		}
//
//			}
//			history[i] = val;
//		}
//		bw.write(Arrays.deepToString(history));
		
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i = 0; i <= N; i++) {
			graph[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(graph[a][b] > w) {
				next[a][b] = b;
				graph[a][b] = w;
			}
			
		}
		for(int k = 1; k <= N; k++) {
			
			for(int a = 1; a <= N; a++) {
				for(int b = 1; b <= N; b++) {
					if(graph[a][k] != INF && graph[k][b] != INF) {
						if(graph[a][b] > graph[a][k] + graph[k][b]) {
							graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
							next[a][b] = next[a][k];	
						}
						}
			}
		}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(graph[i][j] == INF) {
					bw.write(String.valueOf(0) + " ");
							
				} else {
				bw.write(String.valueOf(graph[i][j]) + " ");
			}
				}
			bw.write("\n");
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j || graph[i][j] == INF) {
					bw.write(String.valueOf(0));
				}
				else {
					int cnt = 1;
					int next_val = next[i][j];
					ArrayList<Integer> dist = new ArrayList<>();

					while(next_val != j) {
						cnt += 1;

						dist.add(next_val);
						next_val = next[next_val][j];
					}
					cnt += 1;
					bw.write(cnt + " ");
					bw.write(i + " ");
					
					Iterator iter = dist.iterator();
					while(iter.hasNext()) {
						bw.write(String.valueOf(iter.next()) + " ");
					}
					bw.write(j + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
