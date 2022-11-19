import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr [] =new int [1000001];
		
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=4;i<=n;i++){
			int val = arr[i-1]+1;
			if(i%3==0)
				val = Math.min(val, arr[i/3]+1);
			if(i%2==0)
				val =  Math.min(val, arr[i/2]+1);
			
			arr[i] = val;
		}
		
		System.out.print(arr[n]);
	
	}
}
