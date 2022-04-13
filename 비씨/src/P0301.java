import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://cote.inflearn.com/contest/10/problem/03-01
// obj : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
public class P0301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length1 = Integer.parseInt(br.readLine());
        String[] split1 = br.readLine().split("\\s");

        int length2 = Integer.parseInt(br.readLine());
        String[] split2 = br.readLine().split("\\s");

        System.out.println(solution(length1, split1, length2, split2));

    }

    public static String solution(int length1, String[] arrA, int length2, String[] arrB) {
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;

        while (a < length1 && b < length2) {

            if (Integer.parseInt(arrA[a]) <= Integer.parseInt(arrB[b])) {
                sb.append(arrA[a]).append(" ");
                a++;
            } else {
                sb.append(arrB[b]).append(" ");
                b++;
            }
        }

        while (a < length1) {
            sb.append(arrA[a]).append(" ");
            a++;
        }

        while (b < length2) {
            sb.append(arrB[b]).append(" ");
            b++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}
