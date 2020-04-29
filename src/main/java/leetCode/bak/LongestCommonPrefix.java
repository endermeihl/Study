package leetCode.bak;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char temp=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=temp){
                    return res.toString();
                }
            }
            res.append(temp);
        }
        return res.toString();
    }

    public static void main(String[] args){
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        String[] strs=new String[]{"dog","racecar","car"};
        longestCommonPrefix.longestCommonPrefix(strs);
    }
}
