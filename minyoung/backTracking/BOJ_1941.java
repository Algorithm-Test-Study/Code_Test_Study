import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static char board[][] = new char[5][5];
	static int dx [] = {-1,0,1,0};
	static int dy [] = {0,-1,0,1};
	static int[] combY = new int[25];
    static int[] combX = new int[25];
    static int comb[] = new int [7];
	static int result=0;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++){
            board[i] = br.readLine().toCharArray();
        }

		/*
		 * 자리는 0~24으로 넘버링이 되어있다. 넘버링 된곳의 row와 col를 계산
		 * ex) 13번 자리 => (2,3)
		 */
		
		for(int i=0;i<25;i++) {
			combX[i] = i/5;
			combY[i] = i%5;
		}
		
		combination(0,0,7); //0번 노드에서부터 시작
		
		System.out.print(result);
		
	}
	
	//idx => comb의 index, node => 자리번호, remain => 몇개 남았는지
	static void combination(int idx, int node, int remain ) {
		//7자리 다 선택했을 경우
		if(remain == 0) {
			//이어져 있는지 확인
			bfs();
			return;
		}
		if(node == 25) {
			return;
		}
		
		/*
		 * 부분수열 문제와 같이 풀이
		 * 자리를 선택할지 / 안선택할지
		 */
		comb[idx] = node;
		combination(idx+1, node+1, remain-1); //자리 선택
		combination(idx, node+1,remain); //자리 선택 x
		
	}
	
	static void bfs() {
		//map을 그대로 복사하여 bfs를 진행할수도 있지만
		//1차원 배열에서 map을 이용하여 진행할 수 있음
		Queue <Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean [7];
		
	    
		visited[0] = true;
	    queue.add(comb[0]);
	    
	    int count = 1;
	    int dasom = 0;
	    
	    while(!queue.isEmpty()) {
	    	int node = queue.poll();
            if(board[combY[node]][combX[node]] == 'S') 
            	dasom++;
	    	
	    	for(int i=0;i<4;i++) {
	    		int nx = combX[node] + dx[i];
	    		int ny = combY[node] + dy[i];
	    		
	    		for(int a=1; a<7; a++){
                    if(!visited[a] && nx == combX[comb[a]] && ny == combY[comb[a]]){
                        visited[a] = true;
                        queue.add(comb[a]);
                        count++;
                    }

                }
	    			    		
	    	}
	    }
	    
	    if(count == 7) {
	    	if(dasom >= 4) {
	    		result++;
	    	}
	    }
		
		
	}
	
}

/*
 25자리 7자리 선택
 25C7 은 480,700 으로 2초 이내에 수행 가능함
 7자리가 다 붙어있는지 체크 => bfs 사용
  7자리중 4자리 이상이 이다솜파인지 체크
 두 조건을 만족하면 +1
*/
