package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D3_SW문제해결기본1일차_Flatten_이항우.java
 * 
 * 
 * 
 * @author 이항우
 */
public class D3_1208 {

	// 배열의 인덱스는 높이, 값은 해당 높이를 가진 부분의 갯수
	static int[] heightArr = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int dumpCount = Integer.parseInt(br.readLine());
			int maxIndex = -1;
			int minIndex = 101;
			int res = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 100; i++) {
				int height = Integer.parseInt(st.nextToken());
				if(maxIndex < height) {	// 가장 높은 높이를 maxIndex에 넣기
					maxIndex = height;
				}
				if(minIndex > height) {	// 가장 낮은 높이를 minIndex에 넣기
					minIndex = height;
				}
				heightArr[height]++;	// 해당 높이를 갖는 부분의 갯수 증가
			}

			int currDumpCount = 0;
			while(true) {
				// 덤프 카운트동안만 반복
				if(currDumpCount >= dumpCount) {
					break;
				}
				
				// 더이상 해당 높이를 갖는 부분이 없으면 인덱스 옮기기
				if(heightArr[maxIndex] <= 0) {	
					maxIndex--;
					continue;
				}
				if(heightArr[minIndex] <= 0) {
					minIndex++;
					continue;
				}
				
				heightArr[maxIndex]--;
				heightArr[maxIndex - 1]++;
				heightArr[minIndex]--;
				heightArr[minIndex + 1]++;
				currDumpCount++;
			}
			
			res = maxIndex - minIndex;
			
			sb.append("#" + tc + " " + res + "\n");
		}

		System.out.println(sb);
	}

}
