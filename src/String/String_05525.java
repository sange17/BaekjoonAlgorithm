package String;

import java.util.Scanner;

public class String_05525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        char[] arr = sc.next().toCharArray();		// ���� �迭 ����
        int[] dp = new int[M];
        int answer = 0;

        // �迭 Ž���ϸ� "OI" �߰� �� "I"�� �ִ� �ε��� ��ȣ�� dp �迭�� +1�ϱ�
        for (int i = 1; i < M - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
            	dp[i + 1] = dp[i - 1] + 1;

            	// N���� ũ�ų� ���� ���̰� "i - 2 * N + 1"��° �ε���
            	// ��, Pn�� ù I�� ���� ��� answer++
                if (dp[i + 1] >= N && arr[i - 2 * N + 1] == 'I')
                	answer++;
            }
        }

        System.out.println(answer);
	}
}
