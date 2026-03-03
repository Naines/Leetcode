class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length, max=0;
        int lis[]=new int[n];
        Arrays.sort(words, (a, b)->a.length()-b.length());
        for(int i=0;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                ///System.out.println(good(words[j], words[i])+" "+words[i]+" "+words[j]);
                if(good(words[j], words[i])){
                    if(lis[i]<=lis[j]){
                        lis[i]=lis[j]+1;
                    }
                }
            }
            //System.out.println(Arrays.toString(lis)+" "+words[i]+" "+i);
            max= Math.max(max, lis[i]);
        }
        return max;
    }

    boolean good(String a, String b){
        if(b.length()-a.length()!=1) return false;
        int m =a.length(), n=b.length();
        int i=0,j=0;
        while(i<m && j<n){
            if(a.charAt(i)==b.charAt(j)){
                i++;j++;
            }else{
                j++;
            }
        }
        //System.out.println(i+" "+j);
        return (i==m);
    }
}