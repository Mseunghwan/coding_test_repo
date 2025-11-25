import java.io.*;
import java.util.*;

public class baekjoon1600 {
	
	static int possible = -1;
	static int M;
	static int N;
	static int[][] maps;
	static class Node{
		int y;
		int x;
		int k; // 말처럼 이동할 수 있는 횟수
		int w; // 얼마나 걸렸는지
		
		Node(int y, int x, int k, int w){
			this.y = y;
			this.x = x;
			this.k = k;
			this.w = w;
		}
	}
	
	static int[] dy = {1, 0, -1, 0, 1, 1, 2, 2, -1, -1, -2, -2};
	static int[] dx = {0, 1, 0, -1, 2, -2, 1, -1, 2, -2, -1, 1};
	
	static void BFS(int chance, int a, int b) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(new Node(a, b, chance, 0));
		boolean[][][] visited = new boolean[N][M][chance + 1];
        
        visited[a][b][chance] = true;
        
		while(!queue.isEmpty()) {
			
			Node now = queue.poll();
			
			int y = now.y;
			int x = now.x;
			int k = now.k;
			int w = now.w;
			
			if(y == N - 1 && x == M - 1) {
				possible = w;
				return;
			}
			
			for(int i = 0 ; i < 12; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(i > 3 && k <= 0) {
					continue;
				}
				
				int flag = 0;
				if(i > 3) {
					flag = 1;
				}
				int next_k = k - flag;
				if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx][next_k] && maps[ny][nx] == 0) {
					visited[ny][nx][next_k] = true;
					queue.offer(new Node(ny, nx, next_k, w + 1));
				}
			}
			
			
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(K, 0, 0);
		
		bw.write(String.valueOf(possible));
		bw.flush();
		bw.close();
		br.close();
	}
}
