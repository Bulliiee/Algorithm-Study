package Solved;
// 수 정렬하기2(O(nlogn) 합병정렬, 힙정렬 등)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P_2751 {
    static int []temp; // merge sort용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int []arr = new int[input];

        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        
        // arr을 얕은복사로 넘겼기에 그대로 출력
        // System.out.println("<Merge Sort>");
        temp = new int[arr.length];
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

    static void mergeSort(int []arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            int p = start;
            int q = mid + 1;
            int index = p;

            while(p <= mid || q <= end) {
                if(q > end || (p <= mid && arr[p] < arr[q])) {
                    temp[index++] = arr[p++];
                }
                else {
                    temp[index++] = arr[q++];
                }
            }

            for(int i = start; i <= end; i++) {
                arr[i] = temp[i];
            }
        }
    }

    static void heapSort(int []arr) {
        // 만약 높은숫자가 우선순위라면 매개변수로 Collections.reverseOrder() 추가
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 배열 힙에 넣기
        for(int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // 힙에서 우선순위 가장 낮은 값 원소(root노드) 하나씩 뽑기
        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }
}
