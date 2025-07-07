import java.util.*;
import java.io.*;

public class baekjoon2628 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        ArrayList<Integer> heights = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();

        // 처음 양 끝 넣어주기
        heights.add(0);
        heights.add(y);
        widths.add(0);
        widths.add(x);
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++){
            int how = sc.nextInt();
            if(how == 1){
                widths.add(sc.nextInt());
            }else{
                heights.add(sc.nextInt());
            }

        }
        
        Collections.sort(heights);
        Collections.sort(widths);

        // 가장 큰 간격 찾기 : 높이
        int max_h = 0;
        for(int i = 1; i < heights.size(); i++){
            int diff = heights.get(i) - heights.get(i - 1);
            if(max_h < diff){
                max_h = diff;
            }
            
        }

        // 가장 큰 간격 찾기 : 넓이
        int max_w = 0;
        for(int i = 1; i < widths.size(); i++){
            int diff = widths.get(i) - widths.get(i - 1);
            if(max_w < diff){
                max_w = diff;
            }
        }

        System.out.println(max_h * max_w);

    }
}
