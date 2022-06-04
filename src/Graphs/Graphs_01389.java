package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graphs_01389 {
	public static int N, M;
	public static int[][] map;
	// MAX_VALUE(2147483647)�� ����� �� ����� �ٸ� ������ ���ɴϴ�.
	// static final int INF = Integer.MAX_VALUE;
	static final int INF = 999999999;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		
		// map ������ �迭�� �ʱⰪ ����
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = INF;
				if(i == j) {
					map[i][j] = 0;
				}
			}
		}
		
		// ģ�� ���� ǥ��(A -> B == B -> A)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		// �÷��̵� �ͼ� ����(��� ������ ��� �������� ���� �ִ� ��θ� ���ϴ� ���)
		// ���İ��� ���
		for(int k = 1; k <= N; k++) {
			// ��� ���
			for(int i = 1; i <= N; i++) {
				// ���� ���
				for(int j = 1; j <= N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = INF;
		int idx = -1;
		
		// �ɺ� �������� ���� ���� ���� �ε��� Ž��
		// �׷� �ε����� ���� ���� ��� ���� ���� �ε��� ���
		for(int i = 1; i <= N; i++) {
			int count = 0;
			
			for(int j = 1; j <= N; j++) {
				count += map[i][j];
			}
			
			// �ɺ� �������� �� �߿� �ּҰ��� ���ϰ� �ε����� �ֽ�ȭ.
			if(min > count) {
				min = count;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}
