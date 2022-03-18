// 수 정렬하기(O(n^2)정렬 알고리즘(삽입, 버블 등)) 2750
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int[] arr = new int[input];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // System.out.println();
        // selectionSort(arr);
        // System.out.println();
        bubbleSort(arr);
        
    }

    static void printArr(int []arr) {
        StringBuilder sb = new StringBuilder();

        for(int i : arr) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    // 배열 스왑(배열 얕은복사해서 원래배열 값을 교환함)
    static void swap(int []arr, int bigIndex, int minIndex) {
        int temp = arr[bigIndex];
        arr[bigIndex] = arr[minIndex];
        arr[minIndex] = temp;
    }

    // 선택정렬
    static void selectionSort(int []arr) {
        int temp;
        int minIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            temp = Integer.MAX_VALUE;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < temp) {
                    temp = arr[j];
                    minIndex = j;
                }
            }
            if(temp < arr[i]) {
                swap(arr, i, minIndex);
            }
        }

        printArr(arr);
    }

    // 버블정렬
    static void bubbleSort(int []arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    swap(arr, j, i);
                }
            }
        }

        printArr(arr);
    }

}
