package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_05014 {
	static int visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int f = Integer.parseInt(st.nextToken());	// �ְ���
		int s = Integer.parseInt(st.nextToken());	// ��ȣ ��ġ
		int g = Integer.parseInt(st.nextToken());	// ������
		int u = Integer.parseInt(st.nextToken());	// ��
		int d = Integer.parseInt(st.nextToken());	// �ٿ�
		
		visited = new int[f+1];
		
		bfs(f,s,g,u,d);
		
		br.close();
	}
	
	public static void bfs(int f, int s, int g, int u, int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();	// ���� ��ġ
			
			// ������ �� ���� ��
			if(current == g) {
				// ��ư ���� Ƚ�� ���.
				System.out.println(visited[current] - 1);
			}
			
			// ��
			if(current+u <= f && visited[current+u] == 0) {
				// �ö� ���� ������ ��ư ���� Ƚ�� +1
				visited[current+u] = visited[current] + 1;
				q.add(current+u);
			}
			
			// �ٿ�
			if(current-d > 0 && visited[current-d] == 0) {
				// ������ ���� ������ ��ư ���� Ƚ�� +1
				visited[current-d] = visited[current] + 1;
				q.add(current-d);
			}
		}
		
		if(visited[g] == 0) {
			System.out.println("use the stairs");
		}
	}
}
