/**
 * Calculate the number of possible that a person climbing.
 * The idea: every time the person can choose to climb either 1 or 2 steps. Thus the number of possible that a person climb is the 
 * combination the person choose to climb 1 step and 2 step. For example: The number of possible ways the person choose when climbing 5 step.
 * step 1: 1
 * step 2: 1+1(climbing 1 step from step 1 and climbing 2 step from step 0)
 * step 3: 1+2(climbing 1 step from step 2 and climbing 2 step from step 1)
 * step 4: 3+2(climbing 1 step from step 3 and climbing 2 step from step 2)
 * step 5: 5+3(climbing 1 step from step 4 and climbing 2 step from step 3) 
 *
 * @author: Hengjin Tan
 */
import java.util.Scanner;

public class ClimbingStairs {
	 public int climbStairs(int n){
		 if(n==0||n==1)
			 return n;
		 int[] dp=new int[n+1];
		 dp[0]=1;
		 dp[1]=1;
		 for(int i=2;i<=n;i++){
			 dp[i]=dp[i-1]+dp[i-2];
		 }
		 return dp[n];
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs stairs=new ClimbingStairs();
		Scanner keybroad=new Scanner(System.in);
		String input=keybroad.nextLine();
		while(!input.equals("quit")){
			System.out.print("The input is:");
			System.out.println(input);
			System.out.print("The result is:");
			System.out.println(stairs.climbStairs(Integer.parseInt(input)));
			input=keybroad.nextLine();
		}
	}

}
