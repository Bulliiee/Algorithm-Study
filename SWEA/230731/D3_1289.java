package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * D3_1289_원재의메모리복구하기_이항우.java
 * 메모리: 18,436 KB
 * 시간: 97 ms
 *  
 * 먼저 앞에서부터 초기 비트와 현재 비트가 다를 때, 해당 비트 이후로 전부 1 또는 0으로 바뀌게 하는 메서드를 구현한다
 * 그렇게 역전한 비트의 인덱스를 파라미터로 해당 메서드를 재귀호출 하며 카운트를 센다.
 * 종료 조건은 모든 비트가 초기화 현재가 일치하면 된다.
 * 
 * @author 이항우
 *
 */
public class D3_1289 {

	static char[] initMemory;		// 초기 상태의 메모리 비트
	static char[] currentMemory;	// 현재 메모리 비트
	static int result;				// 결과

	static void setMemory(int currIndex) {	// 파라미터는 체크할 현재 인덱스
		if (initMemory.equals(currentMemory)) {	// 초기 메모리 상태와 현재 메모리 상태가 일치하면
			return;								// 재귀 탈출
		}
		
		char setBit;	// 설정할 메모리 비트
		for(int i = currIndex; i < initMemory.length; i++) {	// 현재 체크할 인덱스(파라미터)부터 끝까지 반복
			if(initMemory[i] != currentMemory[i]) {				// 현재 체크할 인덱스의 현재, 초기 메모리의 다른 비트가 i임
				setBit = (currentMemory[i] == '1') ? '0' : '1';	// 현재 메모리 비트를 뒤집어야 하므로 setBit에 역전해서 담음
				for(int j = i; j < initMemory.length; j++) {	// 바꿔야 할 해당 인덱스(i)부터 끝까지 뒤집음
					currentMemory[j] = setBit;
				}
				result++;			// 결과 카운트 +1
				setMemory(i + 1);	// 이후부터 재귀호출
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 출력할 문자열 만들기

		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {	// 테스트 케이스 수만큼 반복
			result = 0;	// 결과를 0으로 초기화

			initMemory = br.readLine().toCharArray();	// 초기 메모리 비트 상태를 사용자 입력으로 만듦 
			currentMemory = new char[initMemory.length];	// 현재 메모리는 초기 비트와 같은 길이이
			for (int i = 0; i < currentMemory.length; i++) {	// '0'으로 초기화
				currentMemory[i] = '0';
			}

			setMemory(0);	// 메서드 호출하며, 파라미터가 현재 체크할 비트임

			sb.append("#" + tc + " " + result + "\n");	// 출력 문자열 만들기
		}

		System.out.println(sb.toString());	// 결과 출력
	}

}
