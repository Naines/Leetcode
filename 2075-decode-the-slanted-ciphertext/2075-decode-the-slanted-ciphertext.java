class Solution {

    //ch___ie___pr
    //3
    //12/3=4
    public String decodeCiphertext(String txt, int row) {
        int n= txt.length(), col= n/row; 
        StringBuilder sb=new StringBuilder();

        for(int c=0;c<col;c++){
            int r=0, j=c;
            while(r<row && j<col){
                sb.append(txt.charAt(r*col+j));
                r++;j++;
            }
        }
        n = sb.length()-1;
        while(n>=0 && sb.charAt(n)==' '){
            n--;
        }

        return sb.substring(0, n+1);
    }
}