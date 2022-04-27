import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// https://cote.inflearn.com/contest/10/problems
// 올바른 괄호
public class P0501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] split = br.readLine().toCharArray();
		Queue<Character> queue = new LinkedList<>();

		for (char c : split) {
			if (c == '(') {
				queue.add(c);
				continue;
			}
			if (c == ')') {
				if (queue.isEmpty()) {
					bw.write("NO");
					bw.flush();
					return;
				} else {
					queue.poll();
				}

			}
		}
		if (!queue.isEmpty()) {
			bw.write("NO");
			bw.flush();
		} else {
			bw.write("YES");
			bw.flush();
		}
	}
}
/*
(()(()))(()
*/
