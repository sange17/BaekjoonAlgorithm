package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mathematics_17425 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num, sum;

		for(int i = 0; i < n; i++) {
			sum = 0;
			num = Integer.parseInt(br.readLine());
			
			if(num == 1) {
				System.out.println(sum + 1);
				continue;
			}
			
			// 1���� n���� ������ ���� ����� ���� ��� ���� ���� ����ϴ� ��
			// 1���� n���� ������ ���� ����� ����
			for(int j = 1; j <= num; j++) {
				if(num % j == 0) {
					sum++;
				}
			}
			
			// switch�� ����ؼ� ��� �������� ��� �� ��� ���� ���� ����ϱ�
			System.out.println(sum);
		}		
	}
}
