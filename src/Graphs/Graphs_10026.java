package Graphs;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Graphs_10026 {
	static int N;
	static String str;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		// �Էµ� ���� ������ 2���� �迭�� ����
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// ���ϻ����� �ƴ� ���
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		
		int notColorBlindness = count;			// ���ϻ����� �ƴ� ����� �� ������ ����
		count = 0;								// ���ϻ����� ��� ���� �� ���� ī��Ʈ �ʱ�ȭ
		visited = new boolean[N + 1][N + 1];	// ���ϻ����� ��� ���� �� �湮 �迭 �ʱ�ȭ
		
		// ���ϻ����� ��� map�� G������ R�� �ٲ� �� dfs�� �����Ѵ�.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		int colorBlindness = count;				// ���ϻ����� ����� �� ������ ����
		
		System.out.println(notColorBlindness + " " + colorBlindness);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		char nowColor = map[x][y];
		for(int i = 0; i < 4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			
			// map ������ ��� ���� ���� �ݺ����� �Ѿ��
			if(nowX < 0 || nowY < 0 || nowX > N || nowY > N) continue;
			
			if(!visited[nowX][nowY] && map[nowX][nowY] == nowColor) dfs(nowX, nowY);
		}
	}
}
