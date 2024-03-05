/* 백준 1043 - 거짓말
 * 유니온 파인드
 * */
import java.io.*;
import java.util.*;

public class Q052_거짓말쟁이가_되긴_싫어 {

    static int[] A;
    static ArrayList<Integer> known;
    static ArrayList<Integer>[] partyList;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        // 진실을 아는 사람들 배열 저장
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        if (T != 0) {
            known = new ArrayList<>();
            for (int i = 0; i < T; i++) {
                known.add(Integer.parseInt(st.nextToken()));
            }

            // 파티 리스트 객체 생성
            partyList = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                partyList[i] = new ArrayList<>();
            }
        }

        // 파티 리스트 만들기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (T != 0) {
                int now = 0;
                for (int j = 0; j < x; j++) {
                    int y = Integer.parseInt(st.nextToken());
                    if (j == 0) {
                        now = A[y];
                    }
                    union(now, y);
                    partyList[i].add(y);
                }
            }
        }

        // 진실을 아는 사람이 없을 경우
        if (T == 0) {
            System.out.println(M);
            return;
        }

        int count = 0;
        for (int i = 1; i <= M; i++) {
            boolean flag = true;
            for (int num : partyList[i]) {
                if (known.contains(find(A[num]))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (known.contains(b)) {
            int temp = a;
            a = b;
            b = temp;
        }

        A[b] = a;
    }

    public static int find(int i) {

        if (A[i] != i) {
            return find(A[i]);
        }

        return i;
    }
}