// 수 정렬하기2(O(nlogn) 합병정렬, 힙정렬 등)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2751 {
    static int []sorted;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int []arr = new int[input];

        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        
        System.out.println("<Merge Sort>");

        sorted = new int[input];
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);

        // System.out.println("<Heap Sort>");
        // heapSort(arr);
        // printArr(arr);
    }

    static void printArr(int []arr) {
        StringBuilder sb = new StringBuilder();

        for(int i : arr) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    // i: 정렬된 왼쪽 리스트의 인덱스
    // j: 정렬된 오른쪽 리스트의 인덱스
    // k: 정렬된 리스트의 인덱스
    // 2개의 인접한 배열arr[left ~ mid], arr[mid + 1 ~ right]의 합병
    // 실제 숫자들이 정렬되는 과정
    static void merge(int []arr, int left, int mid, int right) {
        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = left;

        // 분할 정렬된 d의 합병
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            }
            else {
                sorted[k++] = arr[j++];
            }
        }

        // 남은 값들을 일괄 복사
        if(i > mid) {
            for(l = j; l <= right; l++) {
                sorted[k++] = arr[l];
            }
        }
        else {
            for(l = i; l <= mid; l++) {
                sorted[k++] = arr[l];
            }
        }

        // 배열 sorted[](임시배열)의 리스트를 배열 list[]로 재복사
        for(l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }

    static void mergeSort(int []arr, int left, int right) {
        int mid;

        if(left < right) {
            mid = (left + right) / 2;   // 중간 위치 계산해 리스트를 균등분할
            mergeSort(arr, left, mid);  // 앞쪽부분 리스트 정렬
            mergeSort(arr, mid + 1, right); // 뒤쪽부분 리스트 정렬
            merge(arr, left, mid, right);   // 정렬된 2개의 부분배열 합병
        }
    }

    static void heapSort(int []arr) {

    }
}
