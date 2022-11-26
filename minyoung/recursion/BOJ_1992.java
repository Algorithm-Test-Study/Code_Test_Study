import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	static int n, count =0;
	static int board[][];
	static StringBuilder sb = new StringBuilder();

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n= Integer.parseInt(br.readLine());
		board = new int[n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0,0,n);
		
		System.out.print(sb);

	}
	
	static void quadTree(int r, int c, int size) {
		if(check(r,c,size)) {
			sb.append(board[r][c]);
			return;
		}
		sb.append("(");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				quadTree(r+i*(size/2),c+j*(size/2),size/2);
			}
		}
		sb.append(")");
	}

	static boolean check(int r, int c, int size) {
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(board[r][c] != board[i][j])
					return false;
			}
		}
		return true;
	}
	

	
}
