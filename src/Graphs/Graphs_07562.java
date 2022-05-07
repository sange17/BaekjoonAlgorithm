package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graphs_07562 {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int startX, startY, endX, endY;				// ���۰� �� ��ǥ ����
	static int[] dx = {-2, -1, 2, 1, 2, 1, -2, -1};		// x��ǥ �̵�
	static int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};		// y��ǥ �̵�
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			
			// ���� ��ġ
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// �� ��ġ
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			bfs();
			sb.append(board[endX][endY]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void bfs() {
		Queue<point> que = new LinkedList<>();
		que.add(new point(startX, startY));
		visited[startX][startY] = true;
		
		while(!que.isEmpty()) {
			point p = que.poll();
			int bx = p.pointX;
			int by = p.pointY;
			
			if(bx == endX && by == endY) break;
			
			// ����Ʈ�� �̵��� ��ǥ ����� �� 8�� 
			for(int i = 0; i < 8; i++) {
				int mx = bx + dx[i];
				int my = by + dy[i];
				if(mx >= 0 && mx < N && my >= 0 && my < N && !visited[mx][my]) {
					que.add(new point(mx, my));
					visited[mx][my] = true;
					board[mx][my] = board[bx][by] + 1;
				}
			}
		}
	}
	
	static class point{
		int pointX;
		int pointY;
		public point(int sx, int sy) {
			super();
			this.pointX = sx;
			this.pointY = sy;
		}
	}
}
