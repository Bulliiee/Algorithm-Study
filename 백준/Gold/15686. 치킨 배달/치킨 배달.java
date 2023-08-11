import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 */

class KFC {
	int r;
	int c;
	public KFC(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	static int citySize;	// 도시의 크기
	static int remainKFC;	// 남아야 하는 치킨집(nCr에서 n은 kfc의 크기, r은 이거다)
	
	static ArrayList<KFC> home = new ArrayList<>();	// 집을 넣을 리스트
	static ArrayList<KFC> kfc = new ArrayList<>();	// 치킨집을 넣을 리스트
	
	static KFC[] tempKFC;	// 치킨집 리스트 조합 생성 들어감

	static int result = Integer.MAX_VALUE;		// 결과값 저장용 
	
	// 두 점 사이 거리 구하기
	static int getDistance(KFC p1, KFC p2) {
		return (Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c));
	}
	
	// tempKFC와 home을 사용해서 도시의 치킨거리를 구한다.
	static int getCityChickenDistance() {
		int distance = 0;
		
		// 각 집을 기준으로 거리가 짧은 치킨집의 거리를 더해준다.
		for(int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < remainKFC; j++) {
				int temp = getDistance(home.get(i), tempKFC[j]);
				min = Integer.min(temp, min);
			}
			distance += min;
		}
		
		return distance;
	}
	
	// 치킨집 조합 생성
	static void makeRemainKFC(int cnt, int start) {
		// 치킨집 조합 완성 시 치킨조합의 도시 치킨거리를 구하고 현재 저장된 최소값과 비교 후 갱신한다.
		if(cnt == remainKFC) {
			int tempChickenDistance = getCityChickenDistance();
			result = Integer.min(tempChickenDistance, result);
			return;
		}
		
		for(int i = start; i < kfc.size(); i++) {
			tempKFC[cnt] = kfc.get(i);
			makeRemainKFC(cnt + 1, i + 1);
		}
	}
	
	
	// 최소 치킨거리를 구한다.
	static void getMinChickenDistance() {
		makeRemainKFC(0, 0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		citySize = Integer.parseInt(st.nextToken());
		remainKFC = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < citySize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < citySize; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == 1) {	// 해당 좌표를 집 리스트에 넣음
					home.add(new KFC(i, j));
				}
				else if(temp == 2) {	// 해당 좌표를 치킨집 리스트에 넣음
					kfc.add(new KFC(i, j));
				}
			}
		}
		
		tempKFC = new KFC[remainKFC];
		getMinChickenDistance();
		System.out.print(result);
	}
}
