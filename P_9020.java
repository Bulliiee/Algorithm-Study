// 골드바흐의 추측 9020
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>();
        int testCase = Integer.parseInt(br.readLine());
        int []nums = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            nums[i] = Integer.parseInt(br.readLine());

            // arr에 입력숫자보다 작은 소수 모두 넣기
            arr.clear();
            for(int j = 1; j <= nums[i]; j++) {
                if(isPrime(j)) {
                    arr.add(j);
                }
            }

            // arr에 있는 소수로 조합하기
            getPartition(arr, nums[i]);  
        }
    }   
    
    static void getPartition(ArrayList<Integer> arr, int num) {
        StringBuilder sb = new StringBuilder();
        int bigTemp, smallTemp;
        int bigPrimeNum = 10000, smallPrimeNum = 1;

        for(int i = 0; i < arr.size(); i++) {
            smallTemp = arr.get(i);
            
            if(smallTemp * 2 == num) {
                bigPrimeNum = smallPrimeNum = smallTemp;
                break;
            }
            
            for(int j = i + 1; j < arr.size(); j++) {
                bigTemp = arr.get(j);

                if(smallTemp + bigTemp == num) {
                    if(bigTemp - smallTemp < bigPrimeNum - smallPrimeNum) {
                        bigPrimeNum = bigTemp;
                        smallPrimeNum = smallTemp;
                    }
                }
            }
        }

        sb.append(smallPrimeNum + " " + bigPrimeNum);
        System.out.println(sb);
    }

    static boolean isPrime(int nums) {
        int temp = (int)Math.sqrt(nums);
        
        if(nums == 1) {
            return false;
        }
        else if(nums == 2) {
            return true;
        }

        for(int i = 2; i <= temp; i++) {
            if(nums % i == 0) {
                return false;
            }
        }
        return true;
    }
}
