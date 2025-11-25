import java.io.*;
import java.util.*;


public class baekjoon1106 {
	
	static class Thing implements Comparable<Thing>{
		int w;
		int v; 
		Thing(int w, int v){
			this.w = w;
			this.v = v;
		}
		
		public int compareTo(Thing o) {
			return this.w - o.w;
		}
	}
	
	static int INF = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 호텔 문제
		// 호텔 고객을 적어도 C 명 늘리기 위해 투자해야 하는 돈의 최솟값 구하기
		// 즉 C = 12로, 적어도 12명을 늘리기 위해서 투자하기 위한 돈의 최솟값은
		// (3, 5), (1, 1) 일 때, 10명 까진 비용 3짜리로 2번 늘리고, 나머지 2명을 비용 1짜리로 2번 늘리면
		// 답은 8로, 최소 8 만큼의 비용을 쓸 때 최소비용으로 12명 까지 늘릴 수 있다
		
		st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		

		// DP 문제?
		// 우선 고객 수 기준의 DP 맵을 만들어주자
		// 최대 고객수가 C + 101명 까지(한번에 들어올 수 있는 값이 100)
	
		int[] DP = new int[C + 100];
	    // 가장 적은 비용으로 채워야 하니 우선 DP 맵을 INF 로 초기화
        Arrays.fill(DP, INF);
        // 아무도 없는 0 칸에는 비용 0이니 초기화
		DP[0] = 0;
		
		Thing[] list = new Thing[N];
		
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());	
			// 홍보 비용
			int w = Integer.parseInt(st.nextToken());
			// 얻는 고객
			int v = Integer.parseInt(st.nextToken());
			
			list[i] = new Thing(w, v);
		}
		
        // 선택 가능한 수 돌면서 DP 맵 채워주기
		for(int i = 0;i < N; i++) {
			int w = list[i].w;
			int v = list[i].v;
			
            // 만약 지금 DP[j]와 j - v 에서 + w 만큼 비용 더 든 경우 중 작은걸로 DP맵 초기화
			for(int j = v; j < C + 100; j++) {
				if(DP[j - v] != INF) {
                    
				DP[j] = Math.min(DP[j], DP[j - v] + w);
			}}
		}
		
        
        // 더 큰 값중에 최소가 있을 수도 있으니 최소 C 이상인 것들 중에 최소값 찾아서 리턴해주기
		int min_rs = INF;
		for(int i = C; i < C + 100; i++) {
			if(DP[i] < min_rs) {
				min_rs = DP[i];
			}
		}
		
		bw.write(String.valueOf(min_rs));
		bw.flush();
		bw.close();
		
		br.close();
	}
}
