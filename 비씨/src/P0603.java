import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://cote.inflearn.com/contest/10/problem/06-03
// 삽입 정렬
public class P0603 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("\\s");

		// 포인터1
		for (int i = 1; i < n; i++) {
			String temp = arr[i];
			int j = 0;
			// 포인터2
			for (j = i - 1; j >= 0; j--) {
				if (Integer.parseInt(arr[j]) > Integer.parseInt(temp)) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = temp;
		}

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);

	}
}
/*
6
11 7 5 6 10 9
11 7 7
5 11 7

1 5 7
* */
