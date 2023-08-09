package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BJ_17478_재귀함수가뭔가요_이항우.java
 * 메모리: 14404 KB
 * 시간: 140 ms
 * 
 * 재귀함수로 구현
 * 시작부분
 * 반복하는 부분
 * 끝나는 부분을 잘 나눈다.
 * 
 * @author 이항우
 *
 */
public class BJ_17478 {
	
	static StringBuilder sb = new StringBuilder();	// 문자열 만들기
	static int curr;	// 현재 반복 횟수
	
	static void inputStringBuilder(String str) {	// 언더바가 들어가도록 문자열 만드는 메서드
		for(int i = 0; i < curr; i++) {	// 현재 반복횟수만큼 반복해서
			sb.append("____");	// 언더바를 넣는다.
		}
		sb.append(str);
	}
	
	static void recursive(int count) {	// 재귀 호출할 메서드
		inputStringBuilder("\"재귀함수가 뭔가요?\"\n");	// 반복할 문자열
		
		if(curr >= count) {	// 끝낼 때 문자열
			inputStringBuilder("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");	
			
		} else {	// 반복할 문자열
			inputStringBuilder("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			inputStringBuilder("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			inputStringBuilder("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			
			curr++;
			recursive(count);
		}
		
		inputStringBuilder("라고 답변하였지.\n");	// 반복할 문자열
		curr--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());

		curr = 0;
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");	// 시작할 문자열
		recursive(input);	// 재귀 메서드 호출
		
		System.out.println(sb.toString());
	}

}
