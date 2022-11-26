import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	static int n, min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] team;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		
		team =new int[n][n];
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nCr(0,0);
		System.out.print(min);
	}
	
	public static void nCr(int start, int depth) {
		
		if(depth == n/2) {
			min = Math.min(min, diff());
			return;
		}
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				nCr(i+1, depth+1);
				visited[i] = false;
			}	
		}
	}

	public static int diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(visited[i] && visited[j]) {
					start += team[i][j] + team[j][i];
				}
				else if(!visited[i]&&!visited[j]) {
					link += team[i][j] + team[j][i];
				}
			}
		}
		
		return Math.abs(start-link);
	}
	
}
