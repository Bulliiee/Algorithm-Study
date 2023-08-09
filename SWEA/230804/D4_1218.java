package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * D4_SW문제해결기본_4일차_괄호짝짓기_이항우.java
 * 
 * 문자열의 앞글자부터 한글자씩 읽는다.
 * 읽어서 여는 괄호라면 스택에 넣는다.
 * 닫는 괄호라면 스택의 최상단에서 하나 빼서 짝이 맞는지 비교한다.
 * 짝지 맞지 않는다면 바로 0을 리턴해버린다.
 * 문자열의 마지막 인덱스까지 0으로 리턴된게 없으면 완벽한 괄호이기 때문에 1을 리턴한다.
 * 
 * 메모리: 18216 KB 시간: 99 ms
 * 
 * @author 이항우
 *
 */
public class D4_1218 {

	static int isPair(String brackets, int size) {
		char[] open = { '(', '[', '{', '<' };	// 여는 괄호 모음
		char[] close = { ')', ']', '}', '>' };	// 닫는 괄호 모음
		Stack<Character> stack = new Stack<Character>();	// 스택을 사용한다.
		stack.setSize(size); // 스택의 사이즈를 입력받은 사이즈 만큼 미리 만들어버린다.(Vector)

		// 문자열의 0번부터 끝까지 반복
		for (int i = 0; i < size; i++) {
			char currStrBracket = brackets.charAt(i); // 문자열의 현재 인덱스의 괄호
			// currStrBracket이 여는 괄호라면 스택에 넣음
			for (int j = 0; j < 4; j++) {
				if (currStrBracket == open[j]) {
					stack.add(currStrBracket);
					break;
				}
				// currStrBracket이 닫는 괄호라면 
				else if (currStrBracket == close[j]) {
					char currOpenBracket = stack.pop();	// 스택에서 꺼냄
					for (int k = 0; k < 4; k++) {	// 꺼낸거랑 현재 닫는괄호랑 비교해서 페어가 아니라면 리턴0
						if (currOpenBracket == open[k] && currStrBracket != close[k]) {
							return 0;
						}
					}
					break;
				}
			}
		}

		return 1;	// 위의 과정을 무사히 마쳤다면 리턴 1(성공)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 문자열 만들기용

		int rep = 0;	// 반복 횟수
		while (rep++ < 10) {	// 10회 반복
			int size = Integer.parseInt(br.readLine());	// 문자열 길이 입력
			String brackets = br.readLine();	// 문자열 입력
			int result = isPair(brackets, size);	// 결과 도출 메서드 호출, 파라미터로 문자열과 크기 넘겨준다.

			sb.append("#" + rep + " " + result + "\n");	// 결과 출력 위한 String 만들기
		}

		System.out.println(sb.toString());	// 결과 출력
	}
}
