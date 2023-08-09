package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D4_1233_SW문제해결기본9일차_사칙연산유효성검사_이항우.java
 * 메모리: 20900 KB
 * 시간: 116 ms
 * 
 * 리프노드일 경우는 데이터가 숫자만 나와야 하고
 * 리프노드가 아닌 경우는 연산자만 가능하다.
 * 리프노드일 경우는 입력 데이터가 노드번호, 데이터 2개이고,
 * 리프노드가 아닌 경우는 입력이 노드번호, 데이터, 자식노드1, (자식노드2)로 3~4개이다.
 * 따라서 한 줄 입력이 2개인 경우는 연산자가 들어있다면 리프노드에 연산자가 들어갔으므로 유효성 x
 * 4개인 경우는 숫자가 들어있다면 리프노드가 아닌데 숫자가 들어갔으므로 유효성 x
 * 
 * @author 이항우
 *
 */
public class D4_1233 {
	
	static boolean isNumber(String data) {
		char[] calc = { '+', '-', '*', '/' };
		
		// 입력받은게 연산자라면
		for(int i = 0; i < 4; i++) {
			if(data.charAt(0) == calc[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = 0;	// 10번 테스트
		while(tc++ < 10) {
			int nodeNum = Integer.parseInt(br.readLine());	// 노드 갯수 입력
			boolean isOk = true;	// 유효성 검사 결과
			
			String temp, data;
			// 노드 갯수만큼 반복
			while(nodeNum-- > 0) {
				st = new StringTokenizer(br.readLine());
				if(st.countTokens() > 2) {	// 4개 입력받았다 -> 자식노드가 있다는 뜻
					temp = st.nextToken();	// 토큰 하나 버리기
					data = st.nextToken();	// 데이터 추출
					if(isNumber(data)) {	// 자식노드가 있는데 숫자라면
						isOk = false;
						continue;			// 멈추기 -> 연산 유효성 검사 결과 x
					}
				}
				else {	// 아니다 -> 2개 입력받았다 -> 리프노드
					temp = st.nextToken();	// 토큰 하나 버리기
					data = st.nextToken();	// 데이터 추출
					if(!isNumber(data)) {	// 리프노드인데 연산자라면
						isOk = false;
						continue;			// 멈추기 -> 연산 유효성 검사 결과 x
					}
				}
			}
			
			// 출력
			sb.append("#" + tc + " ");
			if(isOk) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.print(sb.toString());
	}

}
