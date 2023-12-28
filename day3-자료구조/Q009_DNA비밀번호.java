/* 백준 12891 - DNA 비밀번호
*
* 첫 줄 : 임의의 DNA 문자열 길이 S, 비밀번호로 사용할 부분 문자열 길이 P
* 둘째 줄 : 임의의 DNA 문자열
* 셋째 줄 : 부분 문자열에 포함 될 {A, C, G, T} 의 최소 개수가 공백을 구분으로 주어짐
* */

import java.io.*;
import java.util.*;

public class Q009_DNA비밀번호 {
    static int[] check = new int[4];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        int[] ACGT = new int[4];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < S; i++) {

            add(DNA.charAt(i));

            if (i - P >= 0) {
                remove(DNA.charAt(i-P));
            }

            if (i - P + 1 >= 0) {
                for (int j = 0; j < 4; j++) {
                    if (ACGT[j] > check[j]) {
                        break;
                    }
                    if (j == 3) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static void add(char c) {
        if (c == 'A') {
            check[0]++;
        } else if (c == 'C') {
            check[1]++;
        } else if (c == 'G') {
            check[2]++;
        } else {
            check[3]++;
        }
    }

    public static void remove(char c) {
        if (c == 'A') {
            check[0]--;
        } else if (c == 'C') {
            check[1]--;
        } else if (c == 'G') {
            check[2]--;
        } else {
            check[3]--;
        }
    }
}
