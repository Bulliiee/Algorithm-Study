package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미완
 * 
 * @author SSAFY
 *
 */
public class BJ_13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int sihumjang = Integer.parseInt(br.readLine());
		int[] eungsija = new int[sihumjang];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sihumjang; i++) {
			eungsija[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long sum = 0;
		for (int i = 0; i < sihumjang; i++) {
			if (eungsija[i] >= B) {
				sum += 1;
				eungsija[i] -= B;
			}

			if (eungsija[i] == 0) {
				continue;
			}

			if ((eungsija[i] % C) == 0) {
				sum += (eungsija[i] / C);
			} else {
				sum += ((eungsija[i] / C) + 1);
			}
		}

		System.out.print(sum);
	}
}
