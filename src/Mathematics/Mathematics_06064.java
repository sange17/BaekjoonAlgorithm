package Mathematics;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mathematics_06064 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			boolean check = false;
			
			// �ּҰ���� �̿��� �ݺ���
			// i�� M�� ���ϸ� i�� �ּҰ���� ũ�⺸�� ���� ��� �ݺ�
			for(int i = x; i < (N * M); i += M) {
				// x�� ���� N���� ���� �������� y�̸� ��
				if(i % N == y) {
					System.out.println(i + 1);
					check = true;
					break;
				}
			}
			
			// �ּҰ������ ���ų� �Ѿ�� -1 ���
			if(!check) System.out.println(-1);
		}
	}
}
