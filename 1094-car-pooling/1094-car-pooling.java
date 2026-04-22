class Solution {
    //4
    //2, 1,5
    //3, 3,7
    //1234567
    //.---.
    //--.---.
    //2255330
    //2.5.3.0
    //    
    //{1,2} {3,-2} {3,3} {7,-3}
    //1,2  3,3  3,-2  7,-3
    //curr = 2+3-2-3

    public boolean carPooling(int[][] trips, int capacity) {
        int diff[]=new int[1001];
        for(int trip[]: trips){
            int p=trip[0], from=trip[1], to=trip[2];
            diff[from]+=p;
            diff[to]-=p;
        }
        int curr=0;
        for(int x: diff){
            curr+=x;
            if(curr>capacity) return false;
        }
        return true;
    }
}