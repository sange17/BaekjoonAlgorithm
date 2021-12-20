package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mathematics_17425 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		long f[] = new long[1000001];
		long g[] = new long[1000001];
		
		// 1�� ��� ���� ����̹Ƿ� �̸� �迭�� ä���ش�.
		Arrays.fill(f, 1);
		
		// ������ �ڿ��� A�� ����� �迭�� ä���ش�.
		// 1	2	3	4	5	6	7	8	9
		// +1	+1	+1	+1	+1	+1	+1	+1	+1
		// 		+2		+2		+2		+2
		//			+3			+3			+3
		//				+4				+4
		// ...
		// ���� ���� ä��� ������ �ڿ��� A�� ����� ������ ������ �ȴ�.
		// ������ ���� ����� ���ؼ� ����Ѵ�.
		for(int i=2; i<f.length; i++) {
			for(int j=1; i*j<f.length; j++) {
				f[i*j] += i;
			}
		}
		
		// g(1) = f(1)
		// g(2) = f(1)+f(2) = g(1)+f(2)
		// g(3) = f(1)+f(2)+f(3) = g(2)+f(3)
		for(int i=1; i<g.length; i++) {
			g[i] = g[i-1] +f[i];
		}
		
		while(n > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(g[num]).append("\n");
			n--;
		}
		System.out.println(sb);
	}
}
