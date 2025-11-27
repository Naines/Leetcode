class Solution {
    // empty = 15%4 + full = 15/3
    //2nd itr: numbottles = full+empty

    //sum(numBottles)
    //O(logn)



    public int numWaterBottles(int numBottles, int numExchange) {
        int sum =numBottles; ///15
        while(numBottles >= numExchange){
            int empty = numBottles;
            int r = empty%numExchange, 
            q= empty/numExchange;
            empty = r+q;
            numBottles = empty;
            sum+= q;
        }
        return sum;
    }
}