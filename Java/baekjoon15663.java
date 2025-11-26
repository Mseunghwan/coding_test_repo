import java.util.*;
import java.io.*;
import java.sql.ResultSet;


public class baekjoon15663 {
	static int[] nums;
	static int N;
	static int M;

	// 완성된 순열의 중복 출력을 막기 위한 Set
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Set<String> resultSet = new LinkedHashSet<>();
	static void DFS(String go, boolean[] visited, int depth) throws IOException {
		// 종료조건 우선!
		if (depth == M) {
			resultSet.add(go.trim()); // 앞 뒤 공백제거
			return;
		}
		
		int last_val = -1;
		
		for(int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			
			// 동일한 거 제거
			if(nums[i] == last_val) {
				continue;
			}
			
			visited[i] = true;
			last_val = nums[i];
			
			DFS(go + nums[i] + " ", visited, depth + 1);
			visited[i] = false;
		}
		
	}
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		
		for(int i = 0; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}


		Arrays.sort(nums);
		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		DFS("", visited, 0);
		
		for(String now : resultSet) {
			bw.write(now + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}


