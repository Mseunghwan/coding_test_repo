import java.io.*;
import java.util.*;


public class baekjoon14696 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 총 라운드 수
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i ++){
            int[] a = new int[5];
            int[] b = new int[5];
            
            // 총 a 개수, a 종류
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int cnt = Integer.parseInt(st.nextToken());
            // 값 넣기
            for(int j = 1; j <= cnt; j++){
                a[Integer.parseInt(st.nextToken())] += 1;
            }

            // 총 b 개수, b 종류
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2, " ");
            int cnt2 = Integer.parseInt(st2.nextToken());
            // 값 넣기
            for(int j = 1; j <= cnt2; j++){
                b[Integer.parseInt(st2.nextToken())] += 1;
            }

            for(int j = 4; j > 0; j--){
                if(a[j] > b[j]){
                    System.out.println("A");
                    break;
                }else if(a[j] < b[j]){
                    System.out.println("B");
                    break;
                } else {
                    if(j == 1){
                    System.out.println("D");
                }
                }
            }


        }
    }
}
