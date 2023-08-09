package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 타워 정보 클래스
class Tower {
	int number;
	int height;
	
	public Tower(int number, int height) {
		this.number = number;
		this.height = height;
	}
}

/**
 * BJ_2493_탑_이항우.java
 * 메모리: KB
 * 시간: ms
 * 
 * 
 * 
 * 
 * @author 이항우
 *
 */
public class BJ_2493 {
	
	static Stack<Tower> towers = new Stack<Tower>();		// 타워 담을 스택
	static int[] res;	// 결과 담을 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int towerNum = Integer.parseInt(br.readLine());
		res = new int[towerNum];	// 결과는 타워 갯수만큼
		int resIdx = 0;	// 결과 저장용 인덱스
		st = new StringTokenizer(br.readLine());	// 각 타워 높이 입력
		for(int i = 1; i <= towerNum; i++) {
			int currHeight =Integer.parseInt(st.nextToken());	// 현재 체크하는 높이
			
			// 현재 타워에서 왼쪽으로 가면서 타워 체크
			while(!towers.isEmpty()) {
				if(towers.peek().height > currHeight) {	// 현재 높이보다 왼쪽에 있는것 중 큰거 찾기(같은 높이 탑은 없다)
					res[resIdx++] = towers.peek().number;	// 찾았으면 그 높은 타워 번호를 결과에 넣음
					break;	// 현재 타워에서 쏴서 맞는 가장 가까운 타워를 넣은것이기 때문에 break
				}
				towers.pop();	// 현재 타워보다 작은애니까 pop해버림
			}

			// 위에서 체크 못하고 스택이 비었으면 왼쪽에 닿는 탑이 하나도 없는것이므로 0
			if(towers.isEmpty()) {
				res[resIdx++] = 0;
			}
			
			towers.push(new Tower(i, currHeight));	// 다음으로 넘어가면 현재 타워가 왼쪽이므로 푸시
		}
		
		// 출력
		for(int temp : res) {
			sb.append(temp + " ");
		}
		System.out.print(sb.toString());
	}
	
}
