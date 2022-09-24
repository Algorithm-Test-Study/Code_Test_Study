import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static int N;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList <Character> list; 
		ListIterator<Character> iter; 
		
		N = Integer.parseInt(br.readLine());

		for(int i=0;i<N;i++){
			list = new LinkedList<>();
			iter= list.listIterator();
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='<') {
					if(iter.hasPrevious()) {
						iter.previous();
					}
						
				}
				else if(str.charAt(j)=='>') {
					if(iter.hasNext()) {
						iter.next();
					}
				}
				else if(str.charAt(j)=='-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
				else {
					iter.add(str.charAt(j));
				}
			}
			
			for(Character ch : list) {
				sb.append(ch);
			}
			sb.append('\n');
			
			
		}
		
		System.out.println(sb);
	
	}

}
