class Solution {
    public static String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.",-1);
        String[] ipv6 = IP.split("\\:",-1);
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String s : ipv4) 
                if(isIPv4(s)) continue;
                    else 
                return "Neither";
            return "IPv4";
        }
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            for(String s : ipv6) 
                if(isIPv6(s)) 
                    continue;
                else 
                    return "Neither";
            return "IPv6";
        }
        return "Neither";
    }
    public static boolean isIPv4 (String s){
        try { 
               int val = Integer.parseInt(s);
                return String.valueOf(val).equals(s)
                    && val >= 0
                    && val <= 255;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
   public static boolean isIPv6(String s) {

        if (s.length() == 0 || s.length() > 4)
            return false;

        for (char c : s.toCharArray()) {

            boolean ok =
                    (c >= '0' && c <= '9') ||
                    (c >= 'a' && c <= 'f') ||
                    (c >= 'A' && c <= 'F');

            if (!ok)
                return false;
        }

        return true;
    }
}