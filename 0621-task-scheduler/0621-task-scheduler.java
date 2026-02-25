class Solution {
    public int leastInterval(char[] tasks, int n) {
        //3A,3B,2C,1D, n=3
        int max = 0, maxCount = 0;
        int freq[]=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
            max = Math.max(max, freq[tasks[i]-'A']);
        }
    
        for(int i=0;i<26;i++){
           if(freq[i]==max) maxCount++; 
        }

        int cycles = (n+1)*(max-1);
        int time = cycles + maxCount;
        return Math.max(tasks.length, time);
    }
}