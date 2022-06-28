package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs_14502 {
	// ���̷��� ��ü
	static class virus{
		int x, y;
		
		virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
		
	static int N;								// ���� ����
	static int M;								// ���� ����
	static int[][] map;					// ����
	static int[][] copy_map;		// ���� ����
	
	// �����¿� ��ǥ
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int result = Integer.MIN_VALUE;			// ��������
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		copy_map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		copy_map = map;			// ���� ī��
		
		DFS(0);								// �� ����鼭 ���̷��� ��Ʈ����
		
		System.out.println(result);
	}
	
	public static void DFS(int depth) {
		// �� 3���� �� �������� ���̷��� ��Ʈ����
		if(depth == 3) {
			BFS();
			return;
		}
		
		// �� 3�� ���������� �ٽ� �����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// ��ĭ�̶��
				if(map[i][j] == 0) {
					// �� �����
					map[i][j] = 1;
					DFS(depth + 1);
					// �ٽ� ��������
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void BFS() {
		int[][] virus_map = new int[N][M];
		Queue<virus> queue = new LinkedList<virus>();
		
		// virus map ����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virus_map[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0;  j < M; j++) {
				// ���̷������ ť�� �ִ´�.
				if(virus_map[i][j] == 2) {
					queue.add(new virus(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			virus v = queue.remove();
			
			for(int d = 0; d < 4; d++) {
				int nowX = v.x + dx[d];
				int nowY = v.y + dy[d];
				
				// ���� �ȿ� ������
				if(nowX >= 0 && nowY >=0 && nowX < N && nowY < M) {
					// �� ĭ�̶�� ���̷��� �۶߸��� �ٽ� ť�� �ֱ�
					if(virus_map[nowX][nowY] == 0) {
						virus_map[nowX][nowY] = 2;
						queue.add(new virus(nowX, nowY));
					}
				}
			}
		}
		safe(virus_map);
	}
	
	// ���� ���� ���ϱ�
	public static void safe(int[][] virus_map) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virus_map[i][j] == 0) count++;
			}
		}
		
		result = Math.max(count, result);
	}
	
}
