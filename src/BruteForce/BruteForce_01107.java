// Ʋ�� ���� ä���� ���� ���� ������ �ϴ� ��ư�� �ּ� ���� ���ϱ�
// �̶� ���峭 ��ư�� ������ ���Ѵ�.

package BruteForce;

import java.util.Scanner;

public class BruteForce_01107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// Ʋ�� ���� ä��
		int M = sc.nextInt();			// ���峭 ��ư ����
		
		boolean[] broken = new boolean[10];			// ���峭 ��ư ���� �迭
		
		// ���峭 ��ư ���� broken�迭�� ���
		for(int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}
		
		// Ʋ����� ä�ο��� ���� ä��(100)����, ���밪 ��ȯ
		// ���ڹ�ư �� ���� �̵��� ����� ������ �ʱ�ȭ
		int result = Math.abs(N - 100);
		// ä���� ���� ���������� �̵��Ϸ��� �ϴ� ä���� ������ 0���� 500000������.
		for(int i = 0; i < 1000000; i++) {
			String string = String.valueOf(i);
			int len = string.length();
			
			// �ڸ��� ���ڸ� broken�迭�� �ε����� �Ͽ� ���峭 ��ư�� �������� Ȯ���ϰ� 
			// ���峭 ��ư�� �ִٸ� �ݺ��� ����
			boolean isBreak = false;
			for(int j = 0; j < len; j++) {
				if(broken[string.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			
			// ���峭 ��ư�� !true, ���峪�� ���� ��ư�� !false
			// ���峵�ٸ� ���ǹ� ��� ����, ���峪�� �ʾҴٸ� ���
			// ����ϸ� ���Ʒ� ��ư ���� Ƚ����, ���̸� ���ϰ� �ּڰ��� result�� �����Ѵ�.
			if(!isBreak) {
				int min = Math.abs(N - i) + len;
				result = Math.min(min, result);
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
