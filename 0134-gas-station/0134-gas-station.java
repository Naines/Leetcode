class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //simualtion
        //go thru stations, get fuel and check if fuel available for next itr
        int n = gas.length;
        int Sgas =  Arrays.stream(gas).sum();
        int Scost = Arrays.stream(cost).sum();
        if(Sgas<Scost) return -1;

        int carry = 0,start=-1;
        for(int i=0;i<n;i++){
            int x = gas[i]-cost[i]+carry;
            if(x<0){  
                start = -1;
                carry = 0;
                continue;
            }
            else {
                if(start==-1) start = i;
                carry = x;
            }
        }
        return start;

    }
}