import java.io.*;
import java.util.*;

public class baekjoon2457 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// N 개의 꽃, 
		// 1, 3, 5, 7, 8, 10, 12월 : 31일
		// 4, 6, 9, 11월 : 30일
		// 2월 : 28일
		
		// 3월 1일 부터, 11월 30일 까지 매일 꽃이 한 가지 이상 피어있도록 꽃 선택
		// 선택한 꽃의 최소 개수를 출력
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] flowers = new int[N][4];
		
		for(int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine());
			flowers[i][0] = Integer.parseInt(st.nextToken()); // 시작 달
			flowers[i][1] = Integer.parseInt(st.nextToken()); // 시작 일
			flowers[i][2] = Integer.parseInt(st.nextToken()); // 끝 달
			flowers[i][3] = Integer.parseInt(st.nextToken()); // 끝 일
		}
		
		// 스윕 알고리즘 활용,
		int st_mon = flowers[0][0];
		int st_day = flowers[0][1];
		int en_mon = flowers[0][2];
		int en_day = flowers[0][3];
		for(int i = 1; i < N; i++) {
			
		}
		
	}
}
