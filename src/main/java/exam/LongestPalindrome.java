package exam;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            int maxlen=Math.max(len1,len2);
            if(maxlen>end-start){
                start=i-(maxlen-1)/2;
                end=i+maxlen/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int helper(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
