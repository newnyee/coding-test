import java.io.*;
import java.util.*;

public class Q059_타임머신으로_빨리_가기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        ArrayList<Node59> edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edgeList.add(new Node59(A, B, C));
        }

        if (N == 1) {
            System.out.println("0");
            return;
        }

        long[] D = new long[N + 1]; // int 타입일 때 출력 초과 남
        for (int i = 2; i <= N; i++) {
            D[i] = Integer.MAX_VALUE;
        }


        for (int i = 1; i <= N; i++) {
            for (Node59 node : edgeList) {
                int startCity = node.startCity;
                int endCity = node.endCity;
                int fare = node.fare;
                if (D[startCity] != Integer.MAX_VALUE
                        && D[endCity] > D[startCity] + fare) {
                    if (i == N) {
                        System.out.println("-1");
                        return;
                    }
                    D[endCity] = D[startCity] + fare;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (D[i] == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(D[i]);
            }
        }
    }
}

class Node59 {

    int startCity;
    int endCity;
    int fare;

    public Node59(int startCity, int endCity, int fare) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.fare = fare;
    }
}
