package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_11659_구간합구하기4_이항우.java 
 * 메모리: 63380 KB 
 * 시간: 704 ms
 * 
 * 입력을 받는 배열 외에 누적 합을 구할 배열을 만든다.
 * 누적합 저장 배열은 이전 저장한 누적합 + 입력받은 값으로 계산해서 입력받을때 같이 계산한다.
 * 주의점은 누적합 저장 배열과 입력 배열의 0번 인덱스를 비워서(0으로 초기화) 맞춰준다.
 * 이후 구간의 합을 구할 때는 범위의 마지막 - 처음-1로 계산한다.
 * 
 * @author 이항우
 *
 */
public class BJ_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력용
		StringBuilder sb = new StringBuilder(); // 출력 문자열 만들기용
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 입력 1줄
		int num = Integer.parseInt(st.nextToken());	// 수 갯수 N 
		int rep = Integer.parseInt(st.nextToken());		// 합 구하는 횟수 M
		
		int[] nums = new int[num + 1];	// 숫자 저장할 배열(0 사용 x)
		int[] sums = new int[num + 1];	// 결과 저장할 배열(인덱스는 nums의 인덱스까지 합)
		st = new StringTokenizer(br.readLine());	// 숫자 입력받고
		for(int i = 1; i <= num; i++) {
			nums[i] = Integer.parseInt(st.nextToken());	// 각각 넣기
			sums[i] = nums[i] + sums[i-1];	// 누적 합
		}
		
		// 구간 합 구할 횟수만큼 반복
		for(int i = 0; i < rep; i++) {
			st = new StringTokenizer(br.readLine());	// 구간 입력받기
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append((sums[end] - sums[start - 1]) + "\n");	// 마지막 범위 - 처음 범위-1번으로 계산
		}
				
		System.out.print(sb.toString());
	}
}
