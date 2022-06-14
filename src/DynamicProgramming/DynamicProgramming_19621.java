package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming_19621 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Room> roomList = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int hcount = Integer.parseInt(st.nextToken());
			
			roomList.add(new Room(start, end, hcount));
		}
		
		int rst = getMaxCount(N, roomList);
		System.out.println(rst);
		
		br.close();
	}
	
	
	
	private static int hcount;
	private static int getMaxCount(int n, List<Room> roomList) {
		hcount = 0;
		
		// n�� �ִ� 25, dfs�� �̿�.
		dfs(0, roomList, 0, n);
		
		return hcount;
	}
	
	
	
	public static void dfs(int depth, List<Room> roomList, int cnt, int n) {
		// List�� Max �ε����� n-1�����̹Ƿ� �� �̻��� �Ǵ� ��� ��� ȸ�ǰ� ������.
		if(depth > n - 1) {
			hcount = Math.max(hcount, cnt);
			return;
		}
		
		// ���� ȸ�� �����ϴ� ��� ���� ȸ�� ���� ����
		dfs(depth + 2, roomList, cnt + roomList.get(depth).getHeadcount(), n);
		
		// ���� ȸ�� ���� ���ϴ� ��� ���� ȸ�� ����
		dfs(depth + 1, roomList, cnt, n);
	}
	
	static class Room{
		private int start;
		private int end;
		private int hcount;
		
		public Room(int start, int end, int hcount) {
			this.start = start;
			this.end = end;
			this.hcount = hcount;
		}
		
		public int getStart() {
			return start;
		}
		
		public int getend() {
			return end;
		}
		
		public int getHeadcount() {
			return hcount;
		}
	}
}

