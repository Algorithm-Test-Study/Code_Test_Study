package week6.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 잃어버린 괄호 / 실버2
// '-'가 나오기 전까지의 숫자는 모두 다 더하고
// '-'가 나온 후의 숫자는 아까의 합에서 다 빼주자
public class MissingParenthesis_1541 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int start = 0;//문자열을 잘라 숫자를 만들 때의 시작 인덱스
        int sum = 0;//문제에 제출하는 답
        boolean flag = false;//현재의 인덱스까지 '-'가 나온적이 있나?
        int num = 0;//문자열을 잘라 만든 숫자를 저장하는 변수
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')//숫자면
                continue;//넘어가고
            num = Integer.parseInt(str.substring(start, i));//숫자가 아닌게 나타나면 정수로 변환
            if(!flag){//아직 '-'가 나타나기 전이면
                sum += num;//더하고
            }
            else{//'-'가 나타난 이후면
                sum -= num;//뺀다
            }
            if(str.charAt(i) == '-') flag = true;//'-'가 등장하면 flag를 true로 바꾼다.
            start = i+1;//시작인덱스 재설정
        }
        num = Integer.parseInt(str.substring(start));//마지막 숫자 구하기
        if(flag)//플리그 값에 따라 더하거나 뺀다.
            sum -= num;
        else
            sum += num;
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new MissingParenthesis_1541().solution();
    }
}
