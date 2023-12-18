// 백준 11720 - 숫자의 합
import java.util.Scanner;

public class Q01_숫자의합구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int N = sc.nextInt();
        String[] sNums = sc.next().split("");

        for (String num : sNums) {
            sum += Integer.parseInt(num);
        }

        System.out.println(sum);
    }
}
