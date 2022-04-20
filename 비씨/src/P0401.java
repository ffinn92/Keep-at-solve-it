import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// https://cote.inflearn.com/contest/10/problem/04-01
// 학급회장(해쉬)
public class P0401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalCount = Integer.parseInt(br.readLine());
        String voteString = br.readLine();

        Map<Character, Integer> votes = new HashMap<>();
            votes.put('A', 0);
            votes.put('B', 0);
            votes.put('C', 0);
            votes.put('D', 0);
            votes.put('E', 0);

        for (char c : voteString.toCharArray()) {
            votes.replace(c, votes.get(c) + 1);
        }

        int max = 0;
        Character chosen = '0';
        for (Character c : votes.keySet()) {
            if (max < votes.get(c)) {
                max = votes.get(c);
                chosen = c;
            }
        }

        bw.write(chosen);
        bw.flush();
    }

}

// 15
// BACBACCACCBDEDE
