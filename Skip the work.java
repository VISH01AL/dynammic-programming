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
	     String[] s=br.readLine().split("\\s");
	     int[] arr=new int[n];
	     int[][] dp=new int[n+1][2];
	     for(int i=0;i<n;i++)
	     {
	         arr[i]=Integer.parseInt(s[i]);
	        
	     }
	     sb.append(solve(arr,0,0,dp)+"\n");
	 }
	 System.out.print(sb);
	 }
	 public static int solve(int[] arr,int i,int prevskip,int[][] dp)
	 {
	     
	     if(arr.length==0 || i>=arr.length)
	     {
	         return 0;
	     }
	     if(dp[i][prevskip]!=0)
	     {
	         return dp[i][prevskip];
	     }
	     int curr1=2147483647,curr2=2147483647,curr3=2147483647;
	     if(prevskip==1)
	     {
	         curr1=arr[i]+solve(arr,i+1,0,dp);
	     }
	     else{
	         curr2=arr[i]+solve(arr,i+1,0,dp);
	         curr3=solve(arr,i+1,1,dp);
	     }
	     dp[i][prevskip]=Math.min(curr1,Math.min(curr2,curr3));
	     return dp[i][prevskip];
	 }
}