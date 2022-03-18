// 수 정렬하기2(O(nlogn) 합병정렬, 힙정렬 등)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int []arr = new int[input];

        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println();
        mergeSort(arr);
        System.out.println();
        heapSort(arr);
    }

    static void mergeSort(int []arr) {

    }

    static void heapSort(int []arr) {

    }
}
