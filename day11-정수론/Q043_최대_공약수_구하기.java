/* 백준 1850 - 최대공약수
 * 유클리드 호제법
 * */

import java.io.*;
import java.util.*;

public class Q043_최대_공약수_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = gcd(B, A);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result; i++) {
            bw.write("1");
        }

        bw.flush();
        bw.close();
    }

    static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }
}
