import java.util.*;
import java.io.*;

public class baekjoon10157 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();   
        int k = sc.nextInt();

        if(k > r * c){
            System.out.println("0");
            return;
        }
        int[][] matrix = new int[c][r];
    
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0;
        int y = 0;
        int num = 1;
        int dir = 0;
        while(true){
            // 값 넣기
            matrix[x][y] = num;
            if(num == k){
                System.out.printf("%d %d\n", x + 1, y + 1);
                break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 만약 채워져 있거나 초과 하면 이동
            if(0 > nx || nx >= c || 0 > ny || ny >= r || (matrix[nx][ny] != 0)){
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];

            num += 1;

        }
        
    }
}
