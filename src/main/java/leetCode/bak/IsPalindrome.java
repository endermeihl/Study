package leetCode.bak;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        char[] schar=s.toLowerCase().toCharArray();
        int i=0;
        int j=schar.length-1;
        while(i<j){
            while(!isAlphanumeric(schar[i])){
                i++;
            }
            while(!isAlphanumeric(schar[j])){
                j--;
            }
            if(schar[i]!=schar[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    private boolean isAlphanumeric(char c) {
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }
    public static void main(String[] args){
        IsPalindrome isPalindrome=new IsPalindrome();
        isPalindrome.isPalindrome("aman,");
    }
}
