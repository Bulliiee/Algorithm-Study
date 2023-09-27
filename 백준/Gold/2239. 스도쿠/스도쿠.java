import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr =new int[9][9];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<9;i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				arr[i][j] = c[j]-'0';
			}
		}
		
		dfs(0);
		
		for(int[] temp1 : arr) {
			for(int temp2 : temp1) {
				sb.append(temp2);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int d) {
		
		// 9*9 모두 완료 시(기저조건)
		if(d==81) {
			flag = true;
			return;
		}
	
		// 현재 탐색하는 순서를 9로 나누면 행, 나머지는 열이 된다.
		int r = d/9;	
		int c = d%9;
		
		// 0이 아니라면 다음 탐색
		if(arr[r][c]!=0) {
			dfs(d+1);
		}
		// 0이라면
		else {
			// 숫자 1부터 9까지 체크
			for(int i=1;i<10;i++) {
				// 만약, 체크하는 숫자(i)가 해당 자리에 들어가는 것이 유효하지 않다면
				if(!isValid(r,c,i)) {
					// 다음숫자 체크
					continue;
				}
				// 유효하다면 해당 값을 자리에 넣고
				arr[r][c] = i;
				// 다음자리 체크
				dfs(d+1);
				
				// 기저조건이 아니라면 더이상 선택할 수가 없다는 뜻 => 백트래킹
				if(flag) return;
				arr[r][c]=0;
				
			}
		}
		
	}
	
	// [r][c]자리에 n이 유효한지 체크
	static boolean isValid(int r, int c, int n) {
		
		for(int i=0;i<9;i++) {
			if(arr[i][c]==n || arr[r][i]==n) return false;
		}

		int sr = r/3 * 3;
		int sc = c - c%3;
		for(int row=sr;row<sr+3;row++) {
			for(int col=sc;col<sc+3;col++) {
				if(arr[row][col]==n) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}