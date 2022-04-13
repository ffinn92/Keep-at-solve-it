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
        int[] result = new int[length1 + length2];

        int a = 0;
        int b = 0;
        int r = 0;

        while (a < length1 && b < length2) {

            if (Integer.parseInt(arrA[a]) < Integer.parseInt(arrB[b])) {
                result[r] = Integer.parseInt(arrA[a]);
                a++;
                r++;
                continue;
            }
            if (Integer.parseInt(arrA[a]) > Integer.parseInt(arrB[b])) {
                result[r] = Integer.parseInt(arrB[b]);
                b++;
                r++;
                continue;
            }
            result[r] = Integer.parseInt(arrA[a]);
            r++;
            result[r] = Integer.parseInt(arrB[b]);
            r++;
            a++;
            b++;
        }

        if (a == length1) {
            for (int n = b; n < length2; n++) {
                result[r] = Integer.parseInt(arrB[n]);
                r++;
            }
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        if (b == length2) {
            for (int n = a; n < length1; n++) {
                result[r] = Integer.parseInt(arrA[n]);
                r++;
            }
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
