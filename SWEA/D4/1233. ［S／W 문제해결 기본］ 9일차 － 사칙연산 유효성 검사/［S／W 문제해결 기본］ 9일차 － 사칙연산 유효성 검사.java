import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static boolean isNumber(String data) {
		char[] calc = { '+', '-', '*', '/' };
		
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
				if(st.countTokens() == 4) {	// 4개 입력받았다 -> 자식노드가 있다는 뜻
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
