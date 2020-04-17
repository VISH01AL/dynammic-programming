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
	     String[] s=br.readLine().split(" ");
	     int m=Integer.parseInt(s[0]);
	     int n=Integer.parseInt(s[1]);
	     int[][] dp=new int[m+1][n+1];
	     for(int i=0;i<m+1;i++)
	     {
	         for(int j=0;j<n+1;j++)
	         {
	             dp[i][j]=Integer.MAX_VALUE;
	         }
	     }
	     sb.append(solve(m,n,0,0,dp)+"\n");
	 }
	 System.out.print(sb);
	 }
	 public static int solve(int m,int n,int rp,int cp,int[][] dp)
	 {
	     
	     if(rp==m-1 && cp==n-1)
	     {
	      
	         return 1;
	     }
	     if(dp[rp][cp]!=Integer.MAX_VALUE)
	     {
	         return dp[rp][cp];
	     }
	     int right=0,bottom=0;
	     if(canplace(rp,cp+1,m,n))
	     {
	         right=solve(m,n,rp,cp+1,dp);
	     }
	     if(canplace(rp+1,cp,m,n))
	     {
	         bottom=solve(m,n,rp+1,cp,dp);
	     }
	     return dp[rp][cp]=right+bottom;
	 }
	 public static boolean canplace(int rp,int cp,int m,int n)
	 {
	     return (rp>=0 && cp>=0 && rp<=m-1 && cp<=n-1);
	 }
}