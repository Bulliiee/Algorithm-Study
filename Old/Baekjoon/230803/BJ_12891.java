package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_12891_DNA비밀번호_이항우.java
 * 메모리: 20304 KB
 * 시간: 324 ms
 * 
 * 전부 다 돌려봤는데 시간초과가 났다.
 * 그래서 처음 경우만 체크한 다음, 왼쪽에서 하나 줄이고 오른쪽에서 하나 추가해서 체크하는식으로 했다.
 * 
 * @author 이항우
 *
 */
public class BJ_12891 {
	
	// 체크할 문자열, 시작 문자열, 종료 문자열, 체크 결과 저장 배열, 추가 제외 설정(1, -1)
	static void chkSubStr(String str, int start, int end, int[] chk, int mod) {
		for (int i = start; i < end; i++) {
			switch (str.charAt(i)) {
			case 'A':
				chk[0] += mod;
				break;
			case 'C':
				chk[1] += mod;
				break;
			case 'G':
				chk[2] += mod;
				break;
			case 'T':
				chk[3] += mod;
				break;
			}
		}
	}
	
	// 부분문자열이 룰에 맞게 되는지 여부 리턴
	static boolean isOk(int[] rule, int[] chk) {
		for (int i = 0; i < 4; i++) {
			if (rule[i] > chk[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int strLen = Integer.parseInt(st.nextToken()); // 문자열 길이 입력
		int subStrLen = Integer.parseInt(st.nextToken()); // DNA비밀번호가 될 부분 문자열 길이
		int result = 0;	// DNA비밀번호가 될 결과

		String str = br.readLine(); // 문자열 입력

		int[] rule = new int[4]; // A, C, G, T 각 최소 갯수
		st = new StringTokenizer(br.readLine()); // 한 줄 입력
		for (int i = 0; i < 4; i++) { // A, C, G, T 최소 몇개 필요한지 설정
			rule[i] = Integer.parseInt(st.nextToken());
		}

		int[] chk = new int[4]; // A, C, G, T 각 몇개 들었는지 확인용
		// 초기화
		for (int i = 0; i < 4; i++) {
			chk[i] = 0;
		}
		
		// 처음 경우만 먼저 카운트
		chkSubStr(str, 0, subStrLen, chk, 1);
		if(isOk(rule, chk)) {
			result++;
		}
		
		for(int i = 0; i < strLen - subStrLen; i++) {
			chkSubStr(str, i, i+1, chk, -1);	// 왼쪽에서 하나 줄이기
			chkSubStr(str, i + subStrLen, i + subStrLen + 1, chk, +1);	// 오른쪽에서 하나 추가하기
			if(isOk(rule, chk)) {	// 만들어진 chk와 rule 비교
				result++;
			}
		}
		
		System.out.println(result);	// 결과 출력
	}

}
