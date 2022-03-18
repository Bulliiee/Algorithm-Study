// 영화감독 숌 1436
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int input = Integer.parseInt(br.readLine());

        getNum(input);
    }

    // 종말의 숫자인지 확인(666이 연속으로 있는지)
    static boolean isEndNum(int num) {
        String arr = Integer.toString(num);

        for(int i = 0; i < arr.length() - 2; i++) {
            if(arr.charAt(i) == '6' && arr.charAt(i + 1) == '6' && arr.charAt(i + 2) == '6') {
                return true;
            }
        }

        return false;
    }

    // 숫자 만들기
    static void getNum(int input) {
        int res = 666;
        
        while(input > 1) {
            res++;
            if(!isEndNum(res)) {
                continue;
            }

            input--;
        }

        System.out.println(res);
    }
}
