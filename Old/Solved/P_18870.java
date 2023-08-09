package Solved;
// 좌표 압축 18870
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        
        int []num = new int[input];
        int []sortedNum = new int[input];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input; i++) {
            num[i] = sortedNum[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(sortedNum);

        // 숫자, 순위 쌍
        HashMap<Integer, Integer> map = new HashMap<>();    
        int temp = 0;
        for(int i : sortedNum) {
            if(!map.containsKey(i)) {
                map.put(i, temp);
                temp++;
            }
        }

        for(int i : num) {
            sb.append(map.get(i)).append(' ');
        }
        
        System.out.println(sb);
    }
}