package Solved;
// 진짜 최종 구데기컵 2 2 -> 2번 Binary Game 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gudegi_2 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i <= input; i++) {
            getBin(i);
        }

        System.out.println(sb);
    }

    // num으로 들어온 숫자 2진수로 바꿔서 StringBuilder에 저장
    static void getBin(int num) {
        String temp = Integer.toBinaryString(num);

        sb.append(temp);
    }
}
