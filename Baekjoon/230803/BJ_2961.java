package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_2961_도영이가만든맛있는음식_이항우.java
 * 메모리:14168 KB
 * 시간:128 ms
 * 
 * 신맛과 쓴맛의 차이가 가장 작은 min을 만들고, 계속 비교해서 마지막 결과를 출력한다.
 * 재료 세트를 부분조합으로 만들어서 할 수 있는 경우를 powerset으로 따져서 계산한다.
 * 
 * @author 이항우
 *
 */

// 재료 페어 클래스
class Jaeryo {
	int sinmat;		// 신맛
	int sseunmat;	// 쓴맛
	
	// 생성자
	public Jaeryo(int sinmat, int sseunmat) {
		this.sinmat = sinmat;
		this.sseunmat = sseunmat;
	}
}

public class BJ_2961 {
	static Jaeryo[] jaeryo;			// 재료 담을 배열(입력용)
	static boolean[] isUsed;		// 사용 여부 확인 배열
	static int num;					// 재료 갯수
	static int min = Integer.MAX_VALUE;	// 신맛과 쓴맛의 차이 최소값
	
	// 현재 고려할 재료 인덱스, 누적 신맛, 누적 쓴맛을 파라미터로 넘긴다.
	static void cook(int index) {
		// 기저조건: 현재 고려할 재료 인덱스가 num과 같다면
		if(index == num) {
			int accSin = 1, accSseun = 0;	// 누적된 신맛과 쓴맛
			int temp = 0;
			for(int i = 0; i < num; i++) {
				if(isUsed[i]) {		// 재료를 사용하기로 했다면
					accSin *= jaeryo[i].sinmat;			// 신맛과 쓴맛 계산
					accSseun += jaeryo[i].sseunmat;
				}
			}
			if(accSseun != 0) {	// 쓴맛은 0이 없기 때문에 0일때는 제외한다.
				temp = (int)Math.abs(accSin - accSseun);	// 신맛과 쓴맛의 차
				min = Integer.min(min, temp);	// 구한것과 현재값의 최소값
			}
			return;
		}
		
		// 재료 사용할 때 다음 호출
		isUsed[index] = true;
		cook(index + 1);
		// 재료 사용 안할 때 다음 호출
		isUsed[index] = false;
		cook(index + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		num = Integer.parseInt(br.readLine());
		
		jaeryo = new Jaeryo[num];	// 재료들 담을 배열
		isUsed = new boolean[num];	// 재료 사용여부 배열 만들기
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			jaeryo[i] = new Jaeryo( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		}
		
		cook(0);
		
		System.out.print(min);
	}
	
}
