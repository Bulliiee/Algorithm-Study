// 입출력을 위한 import
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	// 파일 명과 public class이름을 같게 한다.
	
	public static void main(String[] args) throws IOException {	// main 메서드로, 프로그램의 시작점이며, BufferedReader 사용 시 Exception을 JVM에 넘긴다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 위해 버퍼를 사용하는 BufferedReader를 사용한다.
		StringBuilder sb = new StringBuilder();	// 출력을 위한 스트링 생성을 위해 사용한다.

					// 		5분(300초), 	1분(60초), 	10초
		int[] ovenTime = {	300, 		60, 		10};	// 오븐 각 버튼별 설정된 시간
		int[] ovenBtnCnt = {0, 0, 0};	// [0]: A, [1]: B, [2]: C오븐 조작 횟수
		
		int T = Integer.parseInt(br.readLine());	// 굽는 시간 T 입력받기
		
		// 만약 T의 1의자리가 0이라면 시간을 정확하게 맞출 수 있다.
		if(T % 10 == 0) {	// 때문에 1의자리가 0인지 검사한다.
			// 모든 오븐 시간이 가장 작은 10초로 나누어 떨어지므로 그리디하게 접근하는 것이 좋다.
			for(int i = 0; i < ovenBtnCnt.length; i++) {	// 오븐의 갯수만큼 반복한다.
				if(T >= ovenTime[i]) {	// 굽는 시간이 오븐에 설정된 타이머 시간보다 크거나 같다면
					ovenBtnCnt[i] += (T / ovenTime[i]);	// 남은 굽는 시간을 타이머 시간으로 나눈 몫을 알맞은 오븐 버튼 배열에 넣는다.
					T %= ovenTime[i];	// 나머지는 굽는시간의 나머지가 된다.
					if(T == 0) {	// 남은 시간이 0이라면 반복문을 빠져나오게 한다.
						break;		// 가장 바깥 if문에서 1의자리 체크를 해서 3번중 1번은 무조건 여기 걸린다.
					}
				}
			}

			for(int i = 0; i < ovenBtnCnt.length; i++) {	// 오븐 버튼 조작 횟수 배열을 차례로 돌며
				sb.append(ovenBtnCnt[i] + " ");	// 출력할 문자열을 만든다.
			}
		}
		// 만약 T의 1의자리가 0이 아니라면 시간을 정확하게 맞출 수 없다.
		else {
			sb.append(-1);	// 출력할 문자열을 -1로 만든다.
		}
			
		System.out.print(sb.toString());	// 만들어진 문자열을 출력해준다.
	}
	
}
