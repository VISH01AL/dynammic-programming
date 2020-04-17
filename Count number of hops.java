import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	 public static void main (String[] args) throws IOException
	 {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 StringBuffer sb=new StringBuffer();
	 int T=Integer.parseInt(br.readLine());
	 while(T-->0)
	 {
	     int n=Integer.parseInt(br.readLine());
	     int[] dp=new int[n+1];
	     sb.append(hop(n,dp)+"\n");
	 }
	 System.out.print(sb);
	 }
	 
	 public static int hop(int n,int[] dp)
	 {
	     if(n<0)
	     {
	         return 0;
	     }
	     if(n==0)
	     {
	         return 1;
	     }
	     if(dp[n]!=0)
	     {
	         return dp[n];
	     }
	     int smallans=hop(n-1,dp)+hop(n-2,dp)+hop(n-3,dp);
	     return dp[n]=smallans;
	 }
}