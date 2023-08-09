package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_1244_스위치켜고끄기_이항우.java
 * 메모리: 15768 KB
 * 시간: 152 ms
 *
 * 문제에 있는 조건대로 구현한다.
 *
 * @author 이항우
 *
 *
 */
class Student {
	int gender; // 학생 성별
	int num; // 받은 번호

	// 생성자
	Student(int gender, int num) {
		this.gender = gender;
		this.num = num;
	}

	void switchControl(int[] sw, int swNum) {
		if (gender == 1) { // 남학생일 경우
			for (int i = 0; i < swNum; i++) {
				if ((i + 1) % num == 0) {
					sw[i] = (sw[i] + 1) % 2;
				}
			}
		} else if (gender == 2) { // 여학생일 경우
			sw[num - 1] = (sw[num - 1] + 1) % 2; // 받은 번호 뒤집기

			for (int i = 1; i <= swNum; i++) {
				if ((num - i - 1 < 0) || (num + i - 1 >= swNum)) { // 인덱스 벗어난 경우
					break;
				}
				// 대칭일때만 반복
				if (sw[num - i - 1] == sw[num + i - 1]) {
					sw[num - i - 1] = (sw[num - i - 1] + 1) % 2;
					sw[num + i - 1] = (sw[num + i - 1] + 1) % 2;
				} else {
					break;
				}
			}
		}
	}
}

public class BJ_1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int swNum = Integer.parseInt(br.readLine()); // 스위치 갯수 입력
		int[] sw = new int[swNum]; // 스위치 상태 담을 배열

		st = new StringTokenizer(br.readLine()); // 스위치 입력
		for (int i = 0; i < swNum; i++) { // 1번부터 시작하므로
			sw[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine()); // 학생 수 입력

		for (int i = 0; i < studentNum; i++) { // 학생 수만큼 반복
			st = new StringTokenizer(br.readLine()); // 한 줄 입력받고
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 부여받은 번호

			new Student(gender, num).switchControl(sw, swNum); // 호출
		}

		for (int i = 0; i < swNum; i++) {
			System.out.print(sw[i] + " ");
			if ((i + 1) % 20 == 0) { // 20개 단위로 끊어서 출력
				System.out.println();
			}
		}
	}

}
