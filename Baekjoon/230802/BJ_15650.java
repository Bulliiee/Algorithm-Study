package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P_15650_N과M(2)_이항우.java
 * 메모리: 15772 KB
 * 시간: 156 ms
 * 
 * 중복이 없어야해서 중복을 체크하는 boolean배열을 만들었는데
 * 한 수열을 만들 때 시작 인덱스 다음번부터 체크 하기때문에 없어도 된다. 
 * 
 * @author 이항우
 *
 */
public class BJ_15650 {

	static int[] arrs;		// 수열 담을 배열
	static boolean[] used;	// 숫자 중복 체크용 배열
	
	// 사용할 숫자 범위, 수열 길이, 수열을 만들 인덱스, 시작 숫자를 파라미터로 받는다.
	static void makeSequence(int n, int m, int index, int start) {
		// 종료조건: 수열 길이와 수열을 만들 인덱스가 같을 때. 즉, 수열이 다 만들어졌을 때
		if(m == index) {
			for(int i = 0; i < m; i++) {
				System.out.print(arrs[i] + " ");	// 수열을 출력하고
			}
			System.out.println();
			return;	// 해당 수열은 종료한다.
		}
		
		// 반복내용
		// 1, 2와 2, 1이 같은것으로 취급되므로 수열의 첫 시작 인덱스는 꼭 1부터 하지 않는다.
		for(int i = start; i <= n; i++) {	
			if(!used[i]) {	// 사용할 숫자 중복 체크
				arrs[index] = i;	// 수열 배열에 넣고
				used[i] = true;	// 사용 표기
				makeSequence(n, m, index + 1, i + 1);	// 다음 인덱스, 다음 시작숫자를 넘기며 재귀호출
				used[i] = false;	// 수열 하나가 완성되었으므로 사용 표기 해제
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arrs = new int[m];
		used = new boolean[n + 1];	// 0 사용x
		
		makeSequence(n, m, 0, 1);
	}

}

//package baekjoon;
//
//import java.io.*;
//
//public class P_15650 {
//	public static StringBuilder sb = new StringBuilder();
//	public static int[] numbers;
//	
//	public static void numGenerator(int countIndex, int startIndex, int N, int M) {
//		if(countIndex == M) {
//			for(int i=0; i<numbers.length; i++) {
//				sb.append(numbers[i] + " ");
//			}
//			sb.append("\n");
//			
//			return;
//		}
//		
//		for(int i=startIndex; i<=N; i++) {	// 1~n까지 숫자 사용
//			numbers[countIndex] = i;
//			numGenerator(countIndex + 1, i + 1, N, M);
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] line = br.readLine().split(" ");
//		int N = Integer.parseInt(line[0]);
//		int M = Integer.parseInt(line[1]);
//		numbers = new int[M];
//		
//		numGenerator(0, 1, N, M);
//		System.out.println(sb.toString());
//	}
//
//}
