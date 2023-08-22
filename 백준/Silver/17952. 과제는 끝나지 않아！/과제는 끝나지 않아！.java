// 입출력을 위한 import
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {	// 파일 명과 public class이름을 같게 한다.
	
	// 업무 클래스
	static class UpMoo {
		int score;		// 업무 만점 시 점수
		int remTime;	// 과제 해결까지 걸리는 시간으로, 해당 변수를 조작 및 확인 해서 남은 시간으로 활용한다.
		public UpMoo(int score, int remTime) {	// 업무 객체 생성 시 초기화 위한 생성자
			this.score = score;		// 만점 점수 초기화
			this.remTime = remTime;	// 과제 해결까지 걸리는 시간 초기화
		}
	}
	
	public static void main(String[] args) throws IOException {	// main 메서드로, 프로그램의 시작점이며, BufferedReader 사용 시 Exception을 JVM에 넘긴다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 위해 버퍼를 사용하는 BufferedReader를 사용한다.
		StringTokenizer st;	// 입력된 문자열 자르기 위해 사용
		
		int currMin = Integer.parseInt(br.readLine());	// 이번 분기가 몇 분인지 입력
		
		// 업무를 수행하는 방식이 전형적인 스택이다. 따라서 스택을 사용한다.
		Stack<UpMoo> stack = new Stack<UpMoo>();	// 업무 객체를 담을 스택을 만든다.
		int totalScore = 0;	// 최종 점수가 담길 정수형 변수
		// 입력된 분만큼 반복해서 업무 정보가 주어진다.
		while(currMin-- > 0) {
			st = new StringTokenizer(br.readLine());	// 한 줄을 입력받는다.
			
			int com = Integer.parseInt(st.nextToken());	// 가장 첫 숫자를 명령어라고 보고 입력받는다.
			if(com == 1) {	// 명령어가 1이면 새로운 업무가 주어진 경우다.
				int score = Integer.parseInt(st.nextToken());	// 업무 만점 시 점수
				int remTime = Integer.parseInt(st.nextToken());	// 과제 해결까지 걸리는 시간
				stack.add(new UpMoo(score, remTime));	// 스택에 해당 업무를 넣는다.
			}	// 만약 명령어가 0이라면 새로운 업무가 주어지지 않아 위의 if문을 실행하지 않는다.
			
			if(!stack.isEmpty()) {	// 할 업무가 있다면
				stack.peek().remTime--;	// 새로운 업무가 없으므로 남은 시간을 1 줄인다.
				if(stack.peek().remTime == 0) {	// 만약 해당 업무를 끝냈다면 
					totalScore += stack.pop().score;	// 해당 업무의 점수를 최종 점수에 더한다.
				}
			}	// 스택에 아무것도 없다면 즉, 할 업무가 없다면 위의 if문을 실행하지 않는다.
		}
		
		System.out.print(totalScore);	// 최종 점수를 출력한다.
	}
	
}
