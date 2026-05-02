class Solution {
    //PAYPALISHIRING - 14, 3
    //zigazg is required
    /** 
    .  .
    . ..
    .. .
    .  .
    abcdefghijklmn
    a e i m q
    bdfhjlnp
    c g k o
    reached 0, or n-1, then go down or up till s exhaust
    else i+1,j+1 going down, i-1,j+1 going up 
    */

    public String convert(String s, int n) {
        //s1: down/up-> true/false
        //s2: line/bw -> false/true
        if(n==1) return s;
        boolean s2=false;
        List<List<Character>> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        int i=0,j=0,prev=-1,count=0;
        while(j<s.length()){
            char ch=s.charAt(j++);
            if(s2){
                for(int t=n-1;t>=0;t--){
                    if(prev==t+1)
                        list.get(t).add(ch);
                    else
                        list.get(t).add(' ');
                }
                prev--;
                count++;
            }else{
                list.get(i).add(ch);
                prev=i;
                i++;
            }
           
            if(n<=2){
                //reset i
                if(i==n) i=0;
            } else{
                 if(i==n) s2=true;
                 else if(i==0) s2=true; 

                  //dont change state
                if(count==n-2) {
                    s2=false;
                    i=0;
                    prev=-1;
                    count=0;
                }
            }
        }
        return print(list);
    }

    String print(List<List<Character>> list){
        StringBuilder sb=new StringBuilder();
        int n=list.size();
        for(List<Character> l: list){
            for(char s: l){
                // System.out.print(s);
                if(!(s==' '))sb.append(s);
            }
            // System.out.println();
        }
        return sb.toString();
    }
}