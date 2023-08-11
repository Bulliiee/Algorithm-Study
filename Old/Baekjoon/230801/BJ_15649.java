package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_15649_N과M(1)_이항우.java
 * 
 * 메모리: 35088 KB
 * 시간: 340 ms
 * 
 * n은 사용하는 숫자의 갯수
 * m은 수열의 길이다.
 * 
 * 재귀함수는 기저조건과 유도파트를 생각한다.
 * 재귀적으로 호출할 때, 바뀌는 값이 만들 수열의 인덱스다.
 * 따라서 해당 값이 수열의 길이와 일치했을 때가 기저조건이라고 할 수 있다.
 * 수열을 만들 arr배열을 사용하는데, 기저조건을 만족하면 arr배열을 출력하게 한다.
 * 
 * 유도파트는 1부터 n까지 숫자를 사용해 arr을 만들어가면 된다.
 * 파라미터로 받은 length가 arr을 만들 인덱스를 가리킨다.
 * 또한, 한 수열에서 방문한 숫자를 체크하기 위해 used 배열을 사용한다.
 * 
 * 3 2 입력일 때
 * 유도파트를 순서대로 보면
 * 1. 1~3까지 숫자를 사용해 수열을 만들기 위해 차례로 체크한다(사전순)
 *    먼저 1을 본다고 할 때, 아직 1을 사용하지 않았다면 arr에 1을 앞쪽부터 차곡차곡 넣는다.
 * 2. 1을 사용했다고 표시한 후
 * 3. 1 뒤쪽 수열을 만들기 위해 다음 인덱스를 파라미터로 수열을 만드는 메서드를 재귀적으로 호출한다.
 * 4. 사용했다고 표시한 1의 표시를 사용 안한 것으로 되돌려놓는다.
 * 
 * -----------      -------------
 * | 1 | 2 3 |  ->  | 1 | 2 | 3 |
 * -----------      -------------
 * 
 * @author 이항우
 *
 */
public class BJ_15649 {
	
	static int[] arr;		// 만든 수열 담을 배열
	static boolean[] used;	// 숫자 사용 여부 확인용 배열
	static StringBuilder sb = new StringBuilder();	// 문자열 생성
	
	/**
	 * 수열 재귀적 호출로 생성
	 * @param n 입력 n
	 * @param m 입력 m
	 * @param index 만들 수열(arr)의 인덱스라고 생각하면 편하다.
	 */
	static void makeSequence(int n, int m, int index) {
		// 기저조건***
		if(index == m) {				// 수열 한 줄에 대해 인덱스가 m(수열 길이)라면 종료조건이 된다.
			for(int num : arr) {		// 만든 수열을 순회하며
				sb.append(num + " ");	// 출력할 문자열을 만든다
			}
			sb.append('\n');
			return;						// 기저조건 달성했으니 유도파트 실행하지 않도록 return
		}
		
		// 유도파트***
		// 1부터 n까지 사용하므로, 사전 순으로 하므로 1 ~ n 반복
		for(int number = 1; number <= n; number++) {
			if(!used[number]) {					// 한개의 수열을 만드는데 해당 숫자를 사용하지 않았으면
				arr[index] = number;			// 파라미터로 받은 인덱스에 해당 숫자를 넣고
				used[number] = true;			// 해당 숫자 사용했다고 체크
				makeSequence(n, m, index + 1);	// 재귀 호출을 하는데, 다음 인덱스에 대해 arr에 값을 채운다.
				used[number] = false;			// 수열 하나 완성했으니 체크 해제
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄 입력받기
		
		int n = Integer.parseInt(st.nextToken());	// n쪼개기
		int m = Integer.parseInt(st.nextToken());	// m쪼개기
		
		arr = new int[m];			// 수열의 길이만큼
		used = new boolean[n + 1];	// 사용하는 숫자 갯수만큼(0 사용x)
		
		makeSequence(n, m, 0);	// 수열 한 줄에 대해 0번 인덱스부터 수열 만들기 시작
		
		System.out.println(sb.toString());	// 출력
	}
	
}