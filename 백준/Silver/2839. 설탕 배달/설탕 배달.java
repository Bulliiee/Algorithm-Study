import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(br.readLine());
        int temp = 0, count = 0;

        temp = ((sugar - 10) / 10) * 2;
        switch(sugar % 10) {
            case 0:
                count += 2 + temp;
                break;
            case 1:
                count += 3 + temp;
                break;
            case 2:
                count += 4 + temp;
                break;
            case 3:
                count += 1 + temp + 2;
                if(sugar < 10) {
                    count -= 2;
                }
                break;
            case 4:
                if(sugar < 10) {
                    count = -1;
                    break;
                }
                count += 4 + temp;
                break;
            case 5:
                count += 1 + temp + 2;
                if(sugar < 10) {
                    count -= 2;
                }
                break;
            case 6:
                count += 2 + temp + 2;
                if(sugar < 10) {
                    count -= 2;
                }
                break;
            case 7:
                if(sugar < 10) {
                    count = -1;
                    break;
                }
                count += 5 + temp;
                break;
            case 8:
                count += 2 + temp + 2;
                if(sugar < 10) {
                    count -= 2;
                }
                break;
            case 9:
                count += 3 + temp + 2;
                if(sugar < 10) {
                    count -= 2;
                }
                break;
        }

        System.out.println(count);
    }
}