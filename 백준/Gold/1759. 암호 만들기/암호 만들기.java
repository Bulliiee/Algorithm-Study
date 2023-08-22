import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	static int passwordNum, alphabetsNum;
	static char[] alphabets;
	
	static char[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		passwordNum = Integer.parseInt(st.nextToken());
		alphabetsNum = Integer.parseInt(st.nextToken());
		
		alphabets = new char[alphabetsNum];
		result = new char[passwordNum];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < alphabetsNum; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabets);
		makePassword(0, 0);
		
		System.out.print(sb.toString());
	}

	// 조합 사용, alphabetsNum C passwordNum
	static void makePassword(int cnt, int start) {
		if(cnt == passwordNum) {
			int vowelCnt = 0;
			for(int i = 0; i < passwordNum; i++) {
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					vowelCnt++;
				}
			}
			
			if(vowelCnt >= 1 && passwordNum-vowelCnt >= 2) {
				for(int i = 0; i < passwordNum; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i = start; i < alphabetsNum; i++) {
			result[cnt] = alphabets[i];
			makePassword(cnt + 1, i + 1);
		}
	}
	
}