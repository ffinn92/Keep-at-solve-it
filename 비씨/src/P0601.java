import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://cote.inflearn.com/contest/10/problem/06-01
// 선택 정렬
public class P0601 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input2 = br.readLine().split("\\s");

		int startIndex = 0;
		int currentIndex = 0;
		String temp = "";

		while (startIndex < n) {
			int min = Integer.MAX_VALUE;

			for (int i = startIndex; i < n; i++) {
				int num = Integer.parseInt(input2[i]);
				if (num <= min) {
					min = num;
					currentIndex = i;
				}
			}

			temp = input2[startIndex];
			input2[startIndex] = input2[currentIndex];
			input2[currentIndex] = temp;

			startIndex++;
		}

		StringBuilder sb = new StringBuilder();
		for (String s : input2) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}
