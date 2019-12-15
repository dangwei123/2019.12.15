给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

class Solution {
    public String longestPalindrome(String s) {
        int maxlen=0;
        String sb="";
        //StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int len1=longestPalindrome(s,i,i);
            int len2=longestPalindrome(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>maxlen){
                int start=i-(len-1)/2;
                int end=i+(len)/2;
                sb=s.substring(start,end+1);
                maxlen=len;
            }
        }
        return sb;
    }
    private int longestPalindrome(String s,int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}


class Solution {
    public String longestPalindrome(String s) {
        StringBuffer sb=new StringBuffer();
        sb.append("$#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)).append("#");
        }
        int[] p=new int[2*s.length()+2];
        int io=0;
        int mi=0;
        int reslen=0;
        int rescen=0;
        for(int i=1;i<p.length;i++){
            p[i]=mi>i?Math.min(p[2*io-i],mi-i):1;
            while(i+p[i]<p.length&&i-p[i]>=0&&sb.charAt(i+p[i])==sb.charAt(i-p[i])){
                p[i]++;
            }
            if(p[i]>mi){
                mi=p[i];
                io=i;
            }
            if(reslen<p[i]){
                reslen=p[i];
                rescen=i;
            }
        }
        int start=(rescen-reslen)>>>1;
        return s.substring(start,start+reslen-1);
    }
}


给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp [0][n-1];
    }
}

