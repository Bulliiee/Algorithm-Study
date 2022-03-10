import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int firstNum = Integer.parseInt(br.readLine());
        int secondNum = Integer.parseInt(br.readLine());
        int temp = firstNum;

        ArrayList<Integer> prim = new ArrayList<Integer>();

        while(temp <= secondNum) {
            if(temp == 2) {
                prim.add(temp);
            }
            
            for(int i = 2; i < temp; i++) {
                if((temp % i) == 0) {
                    break;
                }
                else {
                    if(i == temp - 1) {
                        prim.add(temp);
                    }
                }
            }
            temp++;
        }

        int sum = 0;
        temp = 10000;   // 최소값
        for(int i = 0; i < prim.size(); i++) {
            sum += prim.get(i);
            if(prim.get(i) < temp) {
                temp = prim.get(i);
            }
        }

        if(sum == 0) {
            sum = -1;
            System.out.println(sum);
        }
        else {
            System.out.println(sum);
            System.out.println(temp);
        }
    }
}
