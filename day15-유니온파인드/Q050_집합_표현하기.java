/* 백준 1717 - 집합의 표현
 * 유니온 파인드
 * */

import java.io.*;
import java.util.*;

public class Q050_집합_표현하기 {

    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            A[i] = i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String question = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (question.equals("0")) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            A[b] = a;
        }
    }

    public static int find(int i) {
        if (i == A[i]) {
            return i;
        }
        return A[i] = find(A[i]);
    }

    public static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }
}
