import java.io.*;
import java.util.*;
public class baekjoon2605 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        // 이런 문제에선 ArrayList 쓰면 편하다
        ArrayList<Integer> lines = new ArrayList<>();

        for(int i = 1 ; i <= n ; i ++){
            lines.add(lines.size() - sc.nextInt(), i);
        }

        for(int i = 0 ; i < n ; i ++){
            System.out.printf("%d ", lines.get(i));
        }
        
    }
}
