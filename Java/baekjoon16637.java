import java.util.*;
import java.io.*;

public class baekjoon16637 {
    static int N;
    static int maxResult = Integer.MIN_VALUE;
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) nums.add(input.charAt(i) - '0');
            else ops.add(input.charAt(i));
        }

        dfs(0, nums.get(0));

        System.out.println(maxResult);
    }

    static void dfs(int idx, int currentVal) {
        if (idx >= ops.size()) {
            maxResult = Math.max(maxResult, currentVal);
            return;
        }

        int res1 = calculate(currentVal, nums.get(idx + 1), ops.get(idx));
        dfs(idx + 1, res1);


        if (idx + 1 < ops.size()) {
            int nextVal = calculate(nums.get(idx + 1), nums.get(idx + 2), ops.get(idx + 1));
            
            int res2 = calculate(currentVal, nextVal, ops.get(idx));
            
            dfs(idx + 2, res2);
        }
    }

    static int calculate(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return 0;
    }
}