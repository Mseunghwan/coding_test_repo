import java.util.*;
import java.io.*;

public class baekjoon10163 {
    public static void main(String[] args) throws IOException{ 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 색종이 장 수
        int n = Integer.parseInt(str);
        
        // 격자
        int[][] matrix = new int[1001][1001];

        // 색종이 개수 돌면서 너비 구하기
        for(int i = 0; i < n; i++){
            String str1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(str1, " ");
        
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());
            int width = Integer.parseInt(st1.nextToken());
            int height = Integer.parseInt(st1.nextToken());

            for(int j = x; j < x + width; j++){
                for(int k = y; k < y + height; k ++){
                    matrix[j][k] = i + 1;
                }
            }

        }

        for(int i = 0; i < n; i ++){
            int sum = 0;
            for(int j = 0; j < 1001; j++){
                for(int k = 0; k < 1001; k++){
                    if(matrix[j][k] == i + 1){
                        sum += 1;
                    }
                }
            }
            System.out.println(sum);
        }
        
    }
}
