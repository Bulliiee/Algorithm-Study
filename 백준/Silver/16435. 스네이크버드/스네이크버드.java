import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
	
	static boolean canEatFruit(int[] height, int idx, int len) {
		if(height[idx] <= len) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fruitNum = Integer.parseInt(st.nextToken());	// 과일 갯수 입력
		int SBLen = Integer.parseInt(st.nextToken());		// 스네이크버드 초기 길이 입력
		
		st = new StringTokenizer(br.readLine());
		
		// 과일 높이 입력
		int[] height = new int[fruitNum];
		for(int i = 0; i < fruitNum; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(height);	// 정렬
		for(int i = 0; i < fruitNum; i++) {
			if(canEatFruit(height, i, SBLen)) {
				SBLen++;
			} else {
				break;
			}
		}
		
		System.out.println(SBLen);
	}

}
