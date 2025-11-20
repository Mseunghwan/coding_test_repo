import java.io.*;
import java.util.*;

public class baekjoon2146 {
	static int N;
	static int[][] maps;
	
	public static class Node {
		int y;
		int x;
		int cnt;
		
		Node(int y, int x, int cnt){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int color = -1;
	
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void BFS(boolean[][] visited, int a, int b) {
		Queue<Node> queue = new LinkedList<>(); 
		queue.offer(new Node(a, b, 0));
		visited[a][b] = true;
		maps[a][b] = color;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int y = now.y;
			int x = now.x;
			int cnt = now.cnt;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < N && visited[ny][nx] == false && maps[ny][nx] > 0) {
					visited[ny][nx] = true;
					maps[ny][nx] = color;
					queue.offer(new Node(ny, nx, 0));
				}
			}
		}
		
	}
	

	static int min_val = Integer.MAX_VALUE;
	
	static void Bridge_BFS(int a, int b) {
		
		boolean[][] visited = new boolean[N][N];
		for(int i = 0 ; i < N; i++)
		{
			Arrays.fill(visited[i], false);
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(a, b, 0));
		visited[a][b] = true;
		int start = maps[a][b];
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int y = now.y;
			int x = now.x;
			int cnt = now.cnt;
			
			if(cnt > min_val) {
				continue;
			}
			
			if(maps[y][x] != 0 && maps[y][x] != start) {
				// �� ������ Ȯ��
				if(min_val > cnt) {
					min_val = cnt;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < N && visited[ny][nx] == false) {
					visited[ny][nx] = true;
					if(maps[ny][nx] == 0) {
						queue.offer(new Node(ny, nx, cnt + 1));
					} else {
						queue.offer(new Node(ny, nx, cnt));
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// BFS ����
		// �켱 ������ �����ؼ�, ���� ���� cnt ���� X
		// �� �ۿ� ������ ���� cnt += 1	
		// �̷��� �ؼ� ������ ������ �ٸ� ������ �̵��ϴ� ����� cnt�� ���� ������ ã�Ƽ� ����
		
		// ����
		// 1. ���� ã�´� - �� �ٸ� �ѹ��� ä���(BFS Ȱ��)
		// 2. ���� �� ��ǥ���� BFS �����ֱ�
		
		N = Integer.parseInt(br.readLine());
		
		maps = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		// 1. ���� ã�´� - �� �ٸ� �ѹ��� ä���(BFS Ȱ��)
		
		boolean[][] visited = new boolean[N][N];
		for(int i = 0 ; i < N; i++)
		{
			Arrays.fill(visited[i], false);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(maps[i][j] > 0 && visited[i][j] == false) {
					BFS(visited, i, j);	
					color -= 1;
				}
			}
		}
		
		
		// 2. ���� �� ��ǥ���� BFS �����ֱ�
		// �� �� �߿� �ϳ��� �����°ɷ� �ϴ� ������ Ʋ�Ⱦ���
		// ��� land ��ǥ�� ������� �ּҰ��� ������ ���� �� �ִ�
		for(int i = 0; i < N; i++) {
		    for(int j = 0; j < N; j++) {
		        if (maps[i][j] != 0) { // �ٴٰ� �ƴϸ� Ž�� ����
		            Bridge_BFS(i, j);
		        }
		    }
		}
		
		bw.write(String.valueOf(min_val));
		
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
	}
	
}
