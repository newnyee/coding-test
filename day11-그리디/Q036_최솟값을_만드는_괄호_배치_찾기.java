/* 백준 1541 - 잃어버린 괄호
 *
 * 해당 수식이 길어져도 마이너스 부호 이후의 숫자들은 괄호로 묶으면 전부 마이너스 숫자를 갖게됨
 *
 * 따라서 첫번째 도출되는 마이너스 부호 이전의 숫자들은 결과(result)에 플러스를 하고
 * 이후 숫자들은 결과(result)에 마이너스를 함
 * (예외, 마이너스 숫자가 없을 경우를 생각하여 로직을 구성)
 * */

import java.util.*;

public class Q036_최솟값을_만드는_괄호_배치_찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String modify = sc.nextLine();

        String[] numbers = modify.split("-", 2);
        int result = 0;

        String[] plusNum = numbers[0].split("\\+");
        for (String s : plusNum) {
            result += Integer.parseInt(s);
        }

        // 예외 처리
        if (numbers.length > 1) {
            String[] minusNum = numbers[1].split("\\+|-");
            for (String s : minusNum) {
                result -= Integer.parseInt(s);
            }
        }

        System.out.println(result);
    }
}
