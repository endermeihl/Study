package leetCode.bak;

public class ValidIPAddress {
    public String validIPAddress(String IP) {
        return isIPV4(IP);
    }

    private String isIPV4(String ip){
        String[] nums=ip.split("\\.");
        for(String num:nums){
            if(num.length()>1 && num.charAt(0)=='0'){
                return "Neither";
            }
            if(Integer.parseInt(num)>255){
                return "Neither";
            }
        }
        return "IPv4";
    }
    private boolean isIPV6(String ip){
        return false;
    }
    public static void main(String[] args){
        ValidIPAddress validIPAddress=new ValidIPAddress();
        String ip="172.016.254.1";
        System.out.println(validIPAddress.isIPV4(ip));
    }
}
