package Solved;
// 통계학 2108
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        int []nums = new int[input];
        int []result = new int[4];

        int sum = 0;
        for(int i = 0; i < input; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        // 정렬
        heapSort(nums);
        
        result[0] = (int)Math.round((double)sum / (double)input);
        result[1] = nums[(input - 1) / 2];
        result[2] = getFreq(nums);
        result[3] = nums[input - 1] - nums[0];

        sb.append(result[0] + "\n" + result[1] + "\n" + result[2] + "\n" + result[3]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 최빈값 찾기
    static int getFreq(int []arr) {
        int res = 0;    // 최빈값
        int counT = 1;
        int temp = 0;
        boolean check = false;  // 최빈값 여러개 경우 2번째 작은거 찾기 위함

        // 1개만 있는 경우 예외처리
        if(arr.length == 1) {
            return arr[0];
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                counT++;
            }
            else if(arr[i] != arr[i + 1]) {
                if(counT > temp) {
                    temp = counT;
                    check = false;
                    res = arr[i];
                }
                else if(counT == temp && !check) {
                    check = true;
                    res = arr[i];
                }
                counT = 1;
            }
        }
        // 마지막 인덱스까지 포함해서 체크
        if(counT > temp) {
            res = arr[arr.length - 1];
        }
        else if(counT == temp && !check) {
            res = arr[arr.length - 1];
        }

        return res;
    }

    static void heapSort(int []arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 배열 힙에 넣기
        for(int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // 힙에서 우선순위 가장 높은 원소(root노드) 하나씩 뽑기
        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }
}
