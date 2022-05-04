import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://cote.inflearn.com/contest/10/problem/06-02
// 버블 정렬
public class P0602 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("\\s");

		// n=5 일땐 4번, n=4 일땐 3번... 작업해야함
		for (int i = 0; i < n - 1; i++) {
			// 1<>2, 2<>3, 3<>4, 4<>5  -  1<>2, 2<>3, 3<>4  -  1<>2, 2<>3  -  1<>2
			for (int j = 0; j < (n - 1) - i; j++) {
				if (toInt(arr[j]) > toInt(arr[j + 1])) {
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
/*
6
13 5 11 7 23 15
*/
