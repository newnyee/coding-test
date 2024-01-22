/* 백준 1427 - 소트인사이드 */

import java.util.*;
import java.io.*;

public class Q017_내림차순으로_자릿수_정렬하기 {

/*    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        Integer[] A = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            A[i] = N.charAt(i) - 48;
        }

        Arrays.sort(A, Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N.length(); i++) {
            bw.write(A[i] + "");
        }

        bw.flush();
        bw.close();
    }*/

    // 다른 풀이
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] A = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
