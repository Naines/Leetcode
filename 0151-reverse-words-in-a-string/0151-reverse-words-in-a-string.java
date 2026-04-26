class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            String cword=words[i].trim();
            if(hasNoWhiteSpace(cword) && cword.length()>0) {
                // System.out.println(cword+".");

                sb.append(cword).append(" ");
            }
        }
        return sb.toString().trim();
    }

    boolean hasNoWhiteSpace(String word){
        for(char c: word.toCharArray()){
            if(c==' ') return false;
        }
        return true;
    }
}