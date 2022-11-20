import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String str = br.readLine();
		
		int sum =0;
		int operand = 0;
		int operator = 1;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)== '+') {
				sum += operand*operator;
				operand = 0;
			}
			else if(str.charAt(i) == '-') {
				sum+=operand*operator;
				operator = -1;
				operand = 0;
			}
			else {
				operand = operand*10+(str.charAt(i)-'0');
			}
				
		}
		
		sum += operand*operator;
		
		System.out.print(sum);

	}
}
