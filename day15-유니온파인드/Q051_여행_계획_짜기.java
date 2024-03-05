import java.io.*;
import java.util.*;

public class Q051_여행_계획_짜기 {

    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                String a = st.nextToken();
                if (a.equals("1")) {
                    union(i, j);
                }
            }
        }

        String result = "YES";
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = A[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < M-1; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (target != A[a]) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        // ???
        if (a < b) {
            A[b] = a;
        } else if (a > b) {
            A[a] = b;
        }
    }

    public static int find(int i) {
        if (i == A[i]) {
            return i;
        }
        return A[i] = find(A[i]);
    }
}
