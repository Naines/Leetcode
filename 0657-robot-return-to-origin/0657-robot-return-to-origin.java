class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int count1 =0, count2=0;
        for(int i=0;i<n;i++){
            char ch =moves.charAt(i);
            switch(ch){
                case 'L':
                count2--;
                break;
                case 'R':
                count2++;
                break;
                case 'U':
                count1--;
                break;
                case 'D':
                count1++;
                break;
                default:
                break;
            }
           
        }
         if(count1==0 && count2==0) return true;
            return false;
    }
}