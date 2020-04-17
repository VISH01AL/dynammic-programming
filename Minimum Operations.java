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
	     sb.append(rec(n,dp)+"\n");
	 }
	 System.out.print(sb);
	 }
	 public static int rec(int n,int[] dp)
	 {
	     if(n==0)
	     {
	         return 0;
	     }
	     if(dp[n]!=0)
	     {
	         return dp[n];
	     }
	     int smallans=2147483647;
	     if(n%2==0)
	     {
	         smallans=1+rec(n/2,dp);
	     }
	    return dp[n]=Math.min(1+rec(n-1,dp),smallans);
	 }
}