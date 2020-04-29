package leetCode.bak;

public class Multiply {
    public String multiply(String num1, String num2) {
        StringBuilder res=new StringBuilder();
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int l1=num1.length();
        int l2=num2.length();
        String[] nums=new String[l1*l2];
        int k=0;
        for(int i=l1-1;i>=0;i--){
            for(int j=l2-1;j>=0;j--){
                String temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+"";
                for(int m=0;m<(l1-i-1)+(l2-j-1);m++){
                    temp=temp+"0";
                }
                nums[k++]=temp;
            }
        }
        String temp2=nums[0];
        for(int i=1;i<l1*l2;i++){
            temp2=addString(temp2,nums[i]);
        }
        res.append(temp2);
        return res.reverse().toString();
    }

    private String addString(String num1,String num2){
        int carry=0;
        StringBuilder res=new StringBuilder();
        int l1=num1.length()-1;
        int l2=num2.length()-1;
        while(l1>=0||l2>=0){
            int n1 = l1>=0 ?num1.charAt(l1)-'0':0;
            int n2 = l2>=0 ?num2.charAt(l2)-'0':0;
            int temp=n1+n2+carry;
            res.append(temp%10);
            carry=temp/10;
            l1--;
            l2--;
        }
        if(carry!=0) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args){
        Multiply multiply=new Multiply();
        multiply.multiply("123","456");
    }
}
