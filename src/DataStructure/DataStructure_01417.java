package DataStructure;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;

public class DataStructure_01417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		// �ĺ� ���� ���� ����
		int dasom = Integer.parseInt(br.readLine());	// �ټ��� �������� ��ǥ ���� ���� ����
		int[] array = new int[N-1];						// �ټ��̸� ������ �� �ĺ��� ��� ��ǥ ���� ���� �迭
		
		// �ټ��̸� ������ ������ �ĺ��� ��� ǥ ���� �迭�� ����
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;		// �ż��ؾ��ϴ� ����� �ּڰ��� ��� ����
		
		// �ĺ��� �ټ��� �ڽ� ȥ���� ���
		if(N == 1) {
			System.out.println("0");
			return;
		}
		
		while(true) {
			// �������� �����Ͽ� ���� ��ǥ�� ���� �ĺ��� ���� ū ���� �ε����� ������ ����
			Arrays.sort(array); 
			boolean flag = true;				// �ټ��̺��� ���� ��ǥ���� �ִ��� �Ǵ�
			int last = array.length - 1;		// ���� ��ǥ�� ���� �ĺ��� �ε���
			
			// �ĺ��� ���� ���� ��ǥ�� ���� �ĺ��� �ټ����� ��ǥ�� �̻��� ���
			if(dasom <= array[array.length - 1]) {
				dasom++;			// �ټ��� ��ǥ +1
				array[last]--;		// ���� ���� ��ǥ�� �޴� �ĺ� -1
				count++;				// �Ѹ� �ż�
				flag = false;		// �ټ��̰� �缱�� ���� �������Ƿ� false�� ����
			}
			
			// �ټ��̺��� ���� ��ǥ���� ���� ���
			if(flag)
				break;
		}
		System.out.println(count);
		br.close();
	}
}
