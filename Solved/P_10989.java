package Solved;
// 수 정렬하기3 (수 범위가 적을 때 사용하는 counting sort)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.HashMap;

public class P_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int []arr = new int[input];
        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        countingSort(arr);
    }

    static void printArr(int []arr) {
        StringBuilder sb = new StringBuilder();

        for(int i : arr) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
    
    static void countingSort(int []arr) {
        int []count = new int[10001];   // 수 범위 10000까지니까
        int []res = new int[arr.length];

        // count배열의 인덱스가 arr배열(입력값)에 들어있는 값, 각각 카운팅해준다.
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // 이전것과 누적합 쌓아서 넣어줌
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int index;
        for(int i = arr.length - 1; i >= 0; i--) {
            index = arr[i];
            count[index]--;
            res[count[index]] = index;  // count로 계산한 인덱스에 값 넣음
        }

        printArr(res);
    }

    // 해쉬맵 사용(시간초과)
    // static void countingSort(int []arr) {
    //     HashMap<Integer, Integer> hm = new HashMap<>();
    //     int []temp = arr.clone();

    //     // 배열값을 해쉬맵에 넣기(arr숫자, 나온 횟수)
    //     for(int i = 0; i < arr.length; i++) {
    //         if(!hm.containsKey(arr[i])) {
    //             hm.put(arr[i], 1);
    //         }
    //         else {
    //             hm.put(arr[i], hm.get(arr[i]) + 1);
    //         }
    //     }

    //     // 해쉬맵 (key, value)중 value를 이전value와 합치기(누적 합)
    //     int accSum = 0;
    //     for(int key : hm.keySet()) {
    //         accSum += hm.get(key);
    //         hm.put(key, accSum);
    //     }

    //     // arr에 다시 저장
    //     int index = 0;
    //     for(int i = 0; i < arr.length; i++) {
    //         index = hm.get(temp[i]) - 1;
    //         arr[index] = temp[i];
    //         hm.put(temp[i], index);
    //     }

    //     // System.out.println(hm);
    // }
}
