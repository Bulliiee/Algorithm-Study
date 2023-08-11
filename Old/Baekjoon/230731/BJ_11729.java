package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BJ_11729_하노이탑이동순서_이항우.java
 * 메모리: 75768 KB
 * 시간: 544 ms
 * 
 * 먼저, 종료 조건은 원판이 1개일 때이다. 원판이 1개일 때는 그냥 3번으로 옮기기만 하면 되기 때문이다.(출력) 
 * 
 * 원판이 3개 있다고 가정했을 때, 메서드의 호출을 보면
 * 1. 2개(3-1개)의 원판을 1(src)에서 2(through)로 옮겨야 한다(가장 큰 원판을 3으로 옮겨야 하기 때문)
 * 2. 가장 큰 원판을 1(src)에서 3(dest)으로 옮긴다(출력)
 * 3. 2(through)에 있는 2개(3-1개)의 원판을 3(dest)으로 옮긴다
 * 
 * 위의 세 단계를 원판이 1개 남을 때까지 재귀적으로 호출하면 된다.
 * 
 * 또한, 메서드를 호출할 때 필요한 거쳐가는 원판은 출발지와 도착지를 제외한 장대의 번호로 설정하면 된다.
 * 1번의 경우에는 거쳐가는 장대가 1과 2가 아닌 3(dest)
 * 3번은 2와 3이 아닌 1(src)이 거쳐가는 장대이다.
 * 
 * @author 이항우
 *
 */
public class BJ_11729 {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	// 인자는 종료조건을 체크할 원판 갯수와 원판을 옮기기 시작할 장대의 번호, 거쳐갈 장대의 번호, 목적지 장대의 번호이다.
	static void movePlate(int plateNum, int src, int through, int dest) {
		if(plateNum == 1) {	// 종료 조건: 옮길 원판이 1개일 때
			count++;
			sb.append(src + " " + dest + "\n");
			return;
		}
		
		movePlate(plateNum - 1, src, dest, through);	// 위의 설명에서 1번에 해당
		count++;
		sb.append(src + " " + dest + "\n");				// 위의 설명에서 2번에 해당
		movePlate(plateNum - 1, through, src, dest);	// 위의 설명에서 3번에 해당
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		
		int plateNum = Integer.parseInt(br.readLine());	// 원판 갯수 입력
		
		movePlate(plateNum, 1, 2, 3);	// 메서드 호출, 파라미터는 원판 갯수, src, through, dest
		
		System.out.println(count + "\n" + sb.toString());	// 결과 출력
	}

}
