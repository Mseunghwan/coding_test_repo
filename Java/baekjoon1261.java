import java.util.*;
import java.io.*;

public class baekjoon1261 {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] maps = new int[N][M];
//		char[][] maps = new char[N][M];
		int[][] visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			// 공백이 없고 붙어져서 input 오는 경우 입력 받기
			String line = br.readLine();
				// line.charAt은 '0', '1' 같은 문자를 반환
				// 여기에 '0' 아스키 코드 빼주면 int 또는 0, 1이 된다
			for(int j = 0; j < M; j ++) {
				maps[i][j] = line.charAt(j) - '0';
			}
		}
		// bfs 로 조지자 --> queue에 넣고 후라락
		// Queue --> LinkedList<>() 인스턴스 할당해서 큐 생성하자.
		// visited[ny][nx] 에 지금까지 cnt 저장, 만약 더 크면 no, 작으면 큐에 넣기
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

	
		Queue<int[]> queue = new LinkedList<>();
		
		// 만약 1이면, cnt += 1, 
		// 이런식으로 천천히 늘리면서 마지막 칸에 이동하면 min 값을 초기화 쌔린다
		queue.add(new int[]{0, 0, 0}); // y, x, cnt
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], INF);
		}
		visited[0][0] = 0;
		
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int y = now[0];
			int x = now[1];
			int now_cnt = now[2];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M) {
					int new_cnt = 0;
					if(maps[ny][nx] == 1) {
						new_cnt = 1;
					}
					if(visited[ny][nx] > now_cnt + new_cnt) {
					// 이 cnt로 초기화
					visited[ny][nx] = now_cnt + new_cnt;
					queue.add(new int[] {ny, nx, now_cnt + new_cnt});
					}
					}
			}
			
			
		}
		
		
		
		bw.write(String.valueOf(visited[N - 1][M - 1]));
		bw.flush();
		bw.close();
		br.close();
		
	}
}