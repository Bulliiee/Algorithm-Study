package Solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        String temp, tempA, tempB;

        temp = br.readLine();   // 입력받기

        // 쪼개기
        StringTokenizer st = new StringTokenizer(temp);
        tempA = st.nextToken();
        tempB = st.nextToken();

        // arraylist에 담기
        for(int i = 0; i < tempA.length(); i++) {
            a.add((int)tempA.charAt(i) - 48);
        }
        for(int i = 0; i < tempB.length(); i++) {
            b.add((int)tempB.charAt(i) - 48);
        }
        
        // 자릿수 맞추기(0채우기)
        int sizeA = tempA.length();
        int sizeB = tempB.length();
        if(sizeA - sizeB > 0) {
            for(int i = 0; i < sizeA - sizeB; i++) {
                b.add(0, 0);
            }
        }
        else if(sizeA - sizeB < 0) {
            for(int i = 0; i < sizeB - sizeA; i++) {
                a.add(0, 0);
            }
        }

        // 더하기
        for(int i = a.size() - 1; i >= 0; i--) {
            res.add(a.get(i) + b.get(i));
        }
        // 캐리 올리기
        for(int i = 0; i < res.size() - 1; i++) {
            if(res.get(i) > 9) {
                res.set(i, res.get(i) - 10);
                res.set(i + 1, res.get(i + 1) + 1);
            }
        }
        
        // 출력하기
        for(int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

}