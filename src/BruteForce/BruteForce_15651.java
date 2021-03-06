package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_15651 {
	static int N, M;
	static int[] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[M];
		
		dfs(0);
		System.out.println(sb);
		br.close();
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			array[depth] = i + 1;
			dfs(depth + 1);
		}
	}
}
