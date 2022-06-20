// <������ ��>
// row�� ���� �ִ��� �������� ����
// col�� ���� �ִ밪�� �Ʒ������� ���Ƽ�
// ����, ������ �Ǵ� ����, ���ʿ��� ������ �ٶ���� ��
// ���� ���� ����� ���ؼ� �� �ʿ��� ���� �� ���� ���� �ѳ��̸� ���߰� 
// �����̱⿡ ���ϱ� 2�� ���־���.
// ���⿡ ���� �Ʒ����� ���� �� ���̴� �ѳ��� N * M * 2�� ���ؼ� 
// ������ �� �Ʒ� �ѳ��̸� ���ߴ�.
// ������ row�� col�� 4 3 4 �̷� ������ ū �� ������ �ѳ��̴� ���� �� ���ٴ� ���� �˰ԵǾ���.
// �׷��� ��� Ž���� �̿��Ͽ� ���� ��ġ�� ������ ĭ�� ���� ĭ�� ���Ͽ� ���� ���� ��ġ�ϸ�
// ���� ��ġ�� ���� �� ���� ���� ���־� ū �� ������ ���� �ѳ��̷� �����־���.

package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Geometry_16931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] xyArray = new int[N][M];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				xyArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result += 2 * N * M;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 4; k++) {
					int nowX = i + dx[k];
					int nowY = j + dy[k];
					if(nowX < 0 || nowY < 0 || nowX > N - 1 || nowY > M - 1) {
						result += xyArray[i][j];
						continue;
					}
					if(xyArray[nowX][nowY] < xyArray[i][j]) {
						result += xyArray[i][j] - xyArray[nowX][nowY];
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
