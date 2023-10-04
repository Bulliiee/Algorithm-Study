import java.io.*;
import java.util.*;

/**
 * KMP 알고리즘
 * 부분 일치 테이블 배열(pi)을 만들어서 패턴이 되는 부분을 건너뛰며 시간을 줄인다.
 * pi와 KMP는 비슷한 구조를 가지며, 비교하는 인덱스인 i와 j의 문자가 다르다면 
 * 일치하는 패턴의 연속되는 부분부분 중 어디로 갈지 pi에서 찾아서 j를 바꾸어주며 일치 여부를 확인한다.
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T = br.readLine();	// 긴 문자열
		String P = br.readLine();	// 패턴 문자열
		
		// pi구하기
		int[] pi = getPi(P);
//		for(int i : pi) {
//			System.out.println(i);
//		}
		// KMP를 통해 패턴 문자열이 나타나는 위치 리스트 구하기
		List<Integer> res = KMP(T, P, pi);
		
		// size는 P가 몇번 나타나는지 나타내는것과 같음
		sb.append(res.size()).append("\n");
		// res안의 결과 하나씩 출력
		for(int temp : res) {
			sb.append(temp+1).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	// pi 구하기
	static int[] getPi(String p) {
		int pLen = p.length();		// 비교 문자열 P의 길이
		int[] pi = new int[pLen];	// pi

		int j = 0;
		// pi[0]은 어차피 0이니까 1부터
		for(int i = 1; i < pLen; i++) {
			// 아래 while은 직전 pi가 0이 아닌경우에만 해당
			// 비교하는 i번째와 j번째가 다르면 j를 이동시키기 위함
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			// 비교하는 i번째와 j번째가 같으면 카운트 늘려주기
			if(p.charAt(i) == p.charAt(j)) {
				j++;
			}
			
			// pi에 값 넣기
			pi[i] = j;
		}
		
		return pi;
	}

	// 리턴 리스트에는 T에서 P가 나타나는 위치들이 저장되어 있음
	static List<Integer> KMP(String t, String p, int[] pi) {
		int tLen = t.length();	// 긴 문자열 t의 길이
		int pLen = p.length();	// 비교 문자열 p의 길이
		List<Integer> res = new ArrayList<Integer>();	// 리턴할 리스트
		
		int j = 0;
		for(int i = 0; i < tLen; i++) {
			while(j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(t.charAt(i) == p.charAt(j)) {
				// 아래 if문은 긴 문자열 안에서 비교 문자열이 연속적으로 모두 만족한 경우가 된다.
				if(j == pLen-1) {
					// 따라서 해당 위치를 찾아서 리스트에 넣는다.
					// 현재 i는 비교문자열이 등장하는 위치로부터 비교문자열 길이만큼 탐색했기에 pLen을 빼준다.
					res.add(i-pLen+1);
					// j를 반복되는 패턴에 따라 pi에서 맞춰주어야 한다. 그래야 다음에 등장하는 비교 문자열도 확인된다.
					j = pi[j];
				}
				// 아직 비교 문자열의 끝까지 확인 안된 경우는 카운트 늘리는 것
				else {
					j++;
				}
			}
		}
		
		return res;
	}
}
