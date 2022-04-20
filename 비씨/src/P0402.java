import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//https://cote.inflearn.com/contest/10/problem/04-02
// 아나그램(해쉬)
public class P0402 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] first = br.readLine().split("");
		String[] second = br.readLine().split("");

		Map<String, Integer> firstMap = new HashMap<>();
		Map<String, Integer> secondMap = new HashMap<>();
		for (int i = 0; i < first.length; i++) {
			firstMap.put(first[i], firstMap.getOrDefault(first[i], 0)+1);
			secondMap.put(second[i], secondMap.getOrDefault(second[i], 0)+1);
		}

		for (String s : firstMap.keySet()) {
			if (!firstMap.get(s).equals(secondMap.get(s))) {
				bw.write("NO");
				bw.flush();
				return;
			}
		}
		bw.write("YES");
		bw.flush();
	}
}

//AbaAeCe
//baeeACA

//abaCC
//Caaab
