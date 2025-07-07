import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class baekjoon2309 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ArrayList<Integer> little = new ArrayList<>();
        int[] little = new int[9];
        // 1. 총합을 구한다
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int val = Integer.parseInt(br.readLine());
            little[i] = val;
            sum += val;
        }
        // 오름차순 정렬
        Arrays.sort(little);

        // 2. 범인 두 명(a, b)을 찾는다
        int a = 0;
        int b = 0;
        for(int i = 0; i < little.length; i ++){
            for(int j = i + 1; j < little.length; j++){
                if(sum - (little[i] + little[j]) == 100){
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(i == a || i == b){
                continue;
            }else{
                System.out.println(little[i]);
            }
        }


    }
}
