import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://cote.inflearn.com/contest/10/problem/05-02
// 괄호 문자 제거
public class P0502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] chars = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char c : chars) {

			if (c == '(') {
				stack.push(c);
				continue;
			}
			if (c == ')') {
				stack.pop();
				continue;
			}
			if (stack.isEmpty()) {
				bw.write(c);
				continue;
			}
		}
		bw.flush();
	}
}

/*
(A(BC)D)EF(G(H)(IJ)K)LM(N)

EFLM
*/
