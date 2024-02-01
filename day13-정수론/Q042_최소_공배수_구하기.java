/* 백준 1934 - 최소공배수
 * 유클리드 호제법
 * */

import java.io.*;
import java.util.*;

public class Q042_최소_공배수_구하기 {

    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B) {
                gcd(A, B);
            } else {
                gcd(B, A);
            }

            bw.write(A * B / result + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
    }

    static void gcd(int A, int B) {

        int num = A % B;

        if (num != 0) {
            gcd(B, num);
        } else {
            result = B;
        }
    }
}
