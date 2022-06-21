// ������ ������ �ƹ��� �پ��ϴ���
// ���ķ� ����Ǿ� �ִٸ� ���� �߷��� �������� 
// �� �� �ִ� ���԰� ��������
// ���� ���  13 10 7 20 �̷��� �� ������ �ִٸ�
// ���� ���� 7�� �������� �� �� �� �� �ִ� �ִ� �߷���  7 * 4�� �ȴ�.
// �߷��� �� ��ƿ �� �ִ� ������ ������ 7�� �������� ��������ȭ �Ǵ� �����̴�.
// �׷��ٸ� �ִ��߷��� ��� ���ϸ� �ɱ�?
// �ִ��߷��� ���� �߷� N���� �ε����� ���� �迭�� �����ؼ� ���� �� ��Ƽ�� ��������
// �ε����� �ϳ��� �Ųٷ� �̵��ϸ� (���� ��ġ�� �ε����� ���� �߷� * �� ������ ����)�� ����ϰ� 
// ������ ����� ������ ũ�ٸ� �װ��� �ִ��߷��� �ȴ�.
// �ٽ� ���� ���� ���� 13 10 7 20�� �����ؼ� 7 10 13 20�� ���
// �迭�� �� �κ�. ��, ū ������ (���� ��ġ�� �ε����� ���� �߷� * �� ������ ����)�� ����Ͽ�
// �پ��� ������ ������ ���� ���� �Ǿ��� �� �ִ�� ��ƿ �� �ִ� �ִ� �߷��� ���� �� �ִ�.

package Greedy;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;

public class Greedy_02217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(array[N-i] * i, max);
		}
		
		System.out.println(max);
	}
}
