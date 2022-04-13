import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://cote.inflearn.com/contest/10/problem/03-02
// A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
public class P0302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length1 = Integer.parseInt(br.readLine());
        List<Integer> list1 = Arrays.stream(br.readLine().split("\\s"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int length2 = Integer.parseInt(br.readLine());
        List<Integer> list2 = Arrays.stream(br.readLine().split("\\s"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        solution(list1, list2).forEach(n-> System.out.print(n+" "));
    }

    private static List<Integer> solution(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer num : list1) {
            map.put(num, true);
        }

        List<Integer> result = new ArrayList<>();

        for (Integer num : list2) {
            if (map.get(num) != null) {
                result.add(num);
            }
        }
        Collections.sort(result);
        return result;
    }

}

// 5
// 1 3 9 5 2
// 5
// 3 2 5 7 8

// 2 3 5
