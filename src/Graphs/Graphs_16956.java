package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graphs_16956 {
	static char[][] map;
	static int R,C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// �ش� ĭ�� ���밡 �ִٸ� �����¿� Ž��
				if(map[i][j] == 'W') {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						// �迭 ������ ��� ���� ���� �ݺ��� �����Ѵ�.
						if(nx >= R || ny >= C || nx < 0 || ny < 0) continue;
						
						// ���� �����¿� ��ġ�� ���� ������ ����� ���� �ִ� ĭ�� �� �� �ִ�.
						if(map[nx][ny] == 'S') flag = false;
						
						// ���� �����¿� ��ġ�� ���� ������ 
						// ���� �����¿� ��ġ�� ��Ÿ���� ��ġ�Ͽ� ���� �ִ� ĭ�� �� �� ������ �Ѵ�.
						if(map[nx][ny] == '.') map[nx][ny] = 'D';
					}
				}
			}
		}
		
		// ��Ÿ���� ��� ��ġ�ص� ���밡 ���� �ִ� ĭ�� �� �� �ִ� ���
		if(flag == false) 
			sb.append(0);
		else {		// ���밡 ���� �ִ� ĭ�� �� �� ���� ��� �� ���
			sb.append(1).append("\n");
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
