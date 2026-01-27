class Solution {
    public int ladderLength(String start, String target, List<String> wordList) {
        //  Set<String> dict=new HashSet<>();
        // for(String s: wordList){
        //     dict.add(s);
        // }
        // Deque<String> q=new ArrayDeque<>();
        // q.addLast(start);
        // int count=1;
        
        // while(!q.isEmpty())
        // {
        //     int size = q.size();
        //     for(int i=0;i<size;i++)
        //     {
        //         char curr[] = q.poll().toCharArray();
        //         for(int j=0;j<curr.length;j++)
        //         {
        //             char temp = curr[j];
        //             for(char ch='a';ch<='z';ch++)
        //             {
        //                 curr[j] = ch;
        //                 String next = new String(curr);
        //                 if(dict.contains(next))
        //                 {
        //                     if(next.equals(target)) 
        //                     return count+1;
        //                     q.addLast(next);
        //                     dict.remove(next);
        //                 }
        //             }
        //             curr[j]=temp;
        //         }
        //     }
        //     count++;
        // }
        // return 0;
        
        Set<String> set = new HashSet<>(wordList);
        Deque<String> q=new ArrayDeque<>();
        q.add(start);
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                char curr[] = q.poll().toCharArray();
                //find that 1 letter var
                System.out.println("AT "+new String(curr));
                for(int i=0;i<curr.length;i++){
                    char t = curr[i];
                    for(int ch='a';ch<='z';ch++){
                        curr[i]=(char)ch;
                        String next = new String(curr);
                        //System.out.println("\n "+next);
                        if(set.contains(next)){
                            if(next.equals(target)) return ans+1;
                            q.addLast(next);
                            set.remove(next);
                        }
                    }
                    curr[i]=t;
                }
            }
            ans++;
        }
        return 0;
    }
}