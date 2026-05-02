class Solution {

    /**
    0,1,8 - not
    2,5 - true
    6,9 -true


    1342
    //contains(3,4,7) return true;

    3,4,7    
     */
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(!isNotGood(i)) {
                // System.out.println(i);
                count++;
            }
        }
        return count;
    }

    boolean isNotGood(int n){
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='3'||c=='4'||c=='7') return true;
            switch(c){
                case '2': sb.append(5);
                         break;
                case '5': sb.append(2);
                         break;
                case '1': sb.append(1);
                         break;
                case '0': sb.append(0);
                        break;
                case '8': sb.append(8);
                        break;
                case '6': sb.append(9);
                        break;
                case '9': sb.append(6);
                        break;
            }
        }
        return s.equals(sb.toString());
    }
}