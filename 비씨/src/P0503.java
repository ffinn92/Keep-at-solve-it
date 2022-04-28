import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://cote.inflearn.com/contest/10/problem/05-03
// 크레인 인형뽑기(카카오)
public class P0503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String[]> list = new ArrayList<>();
		List<Queue<String>> stackList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine().split("\\s"));
			stackList.add(new LinkedList<>());
		}

		int move = Integer.parseInt(br.readLine());
		String[] moves = br.readLine().split("\\s");

		for (String[] strings : list) {
			for (int i = 0; i < n; i++) {
				if (!strings[i].equals("0")) {
					stackList.get(i).add(strings[i]);
				}
			}
		}
		System.out.println(solution(stackList, moves));
	}

	private static int solution(List<Queue<String>> stackList, String[] moves) {
		Stack<String> result = new Stack<>();
		int count = 0;

		for (String s : moves) {
			String doll = "";
			if (!stackList.get(Integer.parseInt(s) - 1).isEmpty()) {
				doll = stackList.get(Integer.parseInt(s) - 1).poll();
				if (result.isEmpty() || !result.peek().equals(doll)) {
					result.push(doll);
					continue;
				}
				if (result.peek().equals(doll)) {
					result.pop();
					count += 2;
				}
			}
		}
		return count;
	}
}
/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4


4
*/
