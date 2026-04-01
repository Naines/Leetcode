class Solution {
    //5,4,3,2,1
    //2,17,9,15,10
    //RRRRR

    //3,5,2,6
    //10,10,15,12
    //RLRL
    
    //2,3,5,6
    //15,10,10,12
    //R,R,L,L
    //

    //123456
    //RRLL
    //1526
    //0,11,0,11
    //sort by index

    static class Robot implements Comparable<Robot>{
        int p,h,i;
        char dir;
        Robot(int p, int h,int i, char dir){
            this.p=p;
            this.h=h;
            this.i=i;
            this.dir=dir;
        }

        public int compareTo(Robot o){
            return this.p-o.p;
        }
        public String toString(){
            return this.p+" "+this.h+" "+dir;
        }

    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot robots[]=new Robot[n];
        for(int i=0;i<n;i++){
            robots[i]=new Robot(positions[i], healths[i],i,directions.charAt(i));
        }
        Arrays.sort(robots);
        // for(Robot r: robots)System.out.println(r);
        Deque<Robot> stack = new ArrayDeque<>();
        for (Robot r : robots) {
            if (r.dir == 'R' ) {
                stack.push(r);
            } else {
                // r.dir == 'L'
                while (!stack.isEmpty() && stack.peek().dir == 'R' && r.h > 0) {
                    Robot top = stack.peek();
                    //both die
                    if (top.h == r.h) {
                        stack.pop();
                        r.h = 0;
                        break;
                    } else if (top.h > r.h) {
                        // top survives, loses 1 health
                        top.h--;
                        r.h = 0;
                        break;
                    } else {
                        // r survives this collision, loses 1 health
                        r.h--;
                        stack.pop();
                    }
                }
                if (r.h > 0) {
                    stack.push(r);
                }
            }
        }

        Map<Integer, Integer> survivors = new HashMap<>();
        while(!stack.isEmpty()){
            Robot r=stack.pop();
            survivors.put(r.i, r.h);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (survivors.containsKey(i)) {
                result.add(survivors.get(i));
            }
        }
        return result;
    }
}