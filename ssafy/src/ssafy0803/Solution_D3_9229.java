package ssafy0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9229 {
	/* 한빈이와 Spot Mart */
	static int T;
	static int N, M;
	static int[] arr;
	static int[] nums;
	static int MAX, Answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			nums = new int[2];
			
			MAX = Integer.MIN_VALUE;
			Answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
		
			 Answer = nCr(0,0);
	         
			 if(Answer == Integer.MIN_VALUE)
				 System.out.println("#" + t + " " + -1);
	         else System.out.println("#" + t+ " " + Answer);
			 
		}
	}
	
	private static int nCr(int cnt, int start) {
		if(cnt == 2) {
            int sum = 0;
            
            for(int i = 0; i < 2; i++) 
                sum += nums[i];
            
            if(MAX < sum && sum <= M) 
            	MAX = sum;
            
            return 0;
        }
		for (int i = start; i < N; i++) {
			nums[cnt] = arr[i];
			nCr(cnt + 1, i + 1);
		}
		return MAX;
	}
}