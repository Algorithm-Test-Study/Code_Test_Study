import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static int x,N;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack <Character> stack1 = new Stack<>();
		Stack <Character> stack2 = new Stack<>();
		

		String str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			stack1.push(str.charAt(i));
		}
		
		N = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("P")) {
				stack1.add(st.nextToken().charAt(0));
			}
			else if(command.equals("L")) {
				if(!stack1.empty()) {
					char ch = stack1.pop();
					stack2.push(ch);
				}
			}
			else if(command.equals("D")) { 
				if(!stack2.empty()) {
					char ch = stack2.pop();
					stack1.push(ch);
				}
			}
			else if(command.equals("B")) {
				if(!stack1.empty()) {
					stack1.pop();
				}
			}
		}
		
		
		while(!stack1.empty()) {
			stack2.push(stack1.pop());
		}
		
		while(!stack2.empty()) {
			bw.write(stack2.pop());
		}
		
		
		
		bw.flush();
	}

}
