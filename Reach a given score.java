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
	     int[] pos={3,5,10};
	     int[][] dp=new int[n+1][pos.length];
	     sb.append(rec(n,pos,dp,0)+"\n");
	 }
	 System.out.print(sb);
	 }
	 public static int rec(int n,int[] pos,int[][] dp,int count){
	     if(count==pos.length)
	     {
	         return 0;
	     }
	     if(n==0 || pos.length==0)
	     {
	         return 1;
	     }
	     if(dp[n][count]!=0)
	     {
	         return dp[n][count];
	     }
	     int smallans=0;
	     if(n-pos[count]>=0)
	     {
	         smallans=rec(n-pos[count],pos,dp,count);
	     }
	     dp[n][count]=smallans+rec(n,pos,dp,count+1);
	     return dp[n][count];
	 }
}