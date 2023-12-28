/* 백준 11003 - 최솟값 찾기
*
* 슬라이딩 윈도우 알고리즘 활용
* 정렬 → 시간복잡도가 nlogn 이므로 슬라이딩 윈도우 + 정렬 알고리즘을 사용하게 되면 시간제한에 걸림
*
* 덱(Deque) 사용
* 1. 최소값 가능성 없는 데이터 삭제 (정렬)
* 2. window 크기 밖 데이터 삭제 (슬라이딩 윈도우)
* */
import java.io.*;
import java.util.*;

public class Q010_최솟값찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 새로 들어올 값과 덱의 마지막 값들 비교
            while (!deque.isEmpty() && deque.getLast().value > num) {
                deque.removeLast();
            }
            deque.addLast(new Node(num, i));

            // 덱의 첫번째 값이 유효한지 확인
            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            // 한번에 출력하기 위해 BufferedWriter 스트림에 넣음
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
