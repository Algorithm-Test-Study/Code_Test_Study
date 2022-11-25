import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayList <Integer> A;
		ArrayList <Integer> B;
		int t = Integer.parseInt(br.readLine());

		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m =Integer.parseInt(st.nextToken());
			ArrayList<int[]> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr.add(new int[] {Integer.parseInt(st.nextToken()),0});
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr.add(new int[] {Integer.parseInt(st.nextToken()),1});
			}
			Collections.sort(arr, new Comparator<int []>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}});
			
			int result = 0;
			int count = 0;
			for(int j=0;j<n+m;j++) {
				if(arr.get(j)[1] == 0) {
					result += count;
				}
				else {
					count++;
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}

	
}
