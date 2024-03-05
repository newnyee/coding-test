/* 백준 2252 - 줄 세우기
 * 위상 정렬
 * */

import java.io.*;
import java.util.*;

public class Q053_줄_세우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int[] D = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            D[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                queue.add(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!queue.isEmpty()) {
            int now = queue.poll();
            bw.write(now + " ");

            for (Integer a : A[now]) {
                D[a]--;
                if (D[a] == 0) {
                    queue.add(a);
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
