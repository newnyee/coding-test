/* 백준 1260 - 미로 탐색
 * 너비 우선 탐색 */

import java.io.*;
import java.util.*;

public class Q027_미로_탐색하기 {

    static int[][] A;
    static boolean[][] visitedArray;
    static int M;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        visitedArray = new boolean[N][M];
        bsf(0,0);
        System.out.println(A[N-1][M-1]);
    }

    static void bsf(int i , int j) {

        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] {i, j});
        visitedArray[i][j] = true;

        while (!myQueue.isEmpty()) {

            int[] now = myQueue.poll();

            // 인접 리스트 탐색
            for (int a = 0; a < 4; a++) {

                int x = now[0] + dx[a];
                int y = now[1] + dy[a];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] != 0 && !visitedArray[x][y]) {
                        visitedArray[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 깊이 업데이트
                        myQueue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
