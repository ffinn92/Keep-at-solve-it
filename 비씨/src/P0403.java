import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://cote.inflearn.com/contest/10/problem/04-03
// 매출액의 종류
public class P0403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		String[] split = br.readLine().split("\\s");
		int total = Integer.parseInt(split[0]);
		int width = Integer.parseInt(split[1]);

		String[] arr = br.readLine().split("\\s");

		Map<String, Integer> map = new HashMap<>();
		// 처음 K개
		for (int i = 0; i < width; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		builder.append(map.keySet().size()).append(" ");

		// 그 다음 K개 ~ 끝까지
		for (int i = 0; i < total - width; i++) {
			map.replace(arr[i], map.get(arr[i]) - 1);
			// 맨 앞의 값에 대한 수량을 -1 했을 때 0이 되면 그 key-value는 map에서 삭제
			if (map.get(arr[i]) == 0) {
				map.remove(arr[i]);
			}
			map.put(arr[i + width], map.getOrDefault(arr[i + width], 0) + 1);

			builder.append(map.keySet().size()).append(" ");
		}

		// 마지막 공백은 지우고 print
		System.out.println(builder.substring(0, builder.length() - 1));
	}

}

/*

7 4
20 12 20 10 23 17 10

[20 12 20 10] 23 17 10
20 [12 20 10 23] 17 10
A,B,A,C,D 가 있을 떄
Set를 쓸까했지만 그럼 위의 예에서 20을 빼고 23을 넣게 되면 12,10,23 밖에 없는 것처러 되어버리니 다른 방법을 찾아야겠다.
4-1, 4-2 와 같은 방식으로 Map을 사용하여 keySet().size()를 활용한다
*/
