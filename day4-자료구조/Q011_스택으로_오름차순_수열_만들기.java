/* 백준 1874 - 스택 수열
* 1. n이 8일 경우 스택에서 [4, 3, 6, 8, 7, 5, 2, 1] 순으로 수를 뽑을 수 있게 1부터 8까지 스택에 숫자를 넣는 방법
*
* 2. 스택에서 숫자 4 가져오기
* -> 4까지의 수를 스택에 넣음 (push 4번)
* │ 4 │
* │ 3 │
* │ 2 │
* │ 1 │
* └─ ─┘
*
* -> pop을 함 -> 4 출력되며 삭제됨 -> 스택에 3까지의 숫자가 남음
* │ 3 │
* │ 2 │
* │ 1 │
* └─ ─┘
*
* 3. 스택에서 숫자 3 가져오기
* -> pop을 함 -> 3 출력되며 삭제됨 -> 스택에 2까지의 숫자가 남음
* │ 2 │
* │ 1 │
* └─ ─┘
*
* 4. 스택에서 숫자 6 가져오기
* -> 6까지의 수를 스택에 넣음 -> 1부터 4까지는 사용했으므로 5와 6이 스택에 들어감
* │ 6 │
* │ 5 │
* │ 2 │
* │ 1 │
* └─ ─┘
*
* -> pop을 함 -> 6 출력되며 삭제됨 -> 스택에 1,2,5의 숫자가 남음
* │ 5 │
* │ 2 │
* │ 1 │
* └─ ─┘
*
* 위의 과정 반복
*
* */

import java.util.*;
import java.io.*;

public class Q011_스택으로_오름차순_수열_만들기 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        int count = 1;
        while (index <= N) {
            if (stack.isEmpty() || stack.peek() < A[index]) {
                stack.push(count);
                sb.append("+\n");
                count++;
            } else if (stack.peek() == A[index]) {
                stack.pop();
                sb.append("-\n");
                index++;
            } else if (stack.peek() > A[index]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
