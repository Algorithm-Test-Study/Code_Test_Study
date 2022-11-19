import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int d[][] = new int [1005][1005];
		String first = br.readLine();
		String second = br.readLine();
		
		for(int i=1;i<=first.length();i++) {
			for(int j=1;j<=second.length();j++) {
				if(first.charAt(i-1) == second.charAt(j-1)) {
					d[i][j] = d[i-1][j-1]+1;
				}
				else {
					d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
				}
			}
		}
		
		System.out.print(d[first.length()][second.length()]);

	}
}
