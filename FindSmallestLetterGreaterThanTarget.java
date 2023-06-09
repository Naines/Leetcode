public class FindSmallestLetterGreaterThanTarget {
    static int upper(char arr[], int lb,int ub, char x){
        while(lb<ub && lb!=arr.length){
            int m = lb +(ub-lb)/2;
            if(arr[m]<=x){
                lb=m+1;
            }else{
                ub=m;
            }
        }
        System.gc();
        return lb==arr.length?-1:lb;
    }
    public static void main(String[] args) {
        char target='z';
        char chs[]={'x','x','y','y'};
        // int ans= ;
        System.out.println(upper(chs, 0, chs.length, target));
        System.out.println(chs[upper(chs, 0, chs.length, target)==-1?0:upper(chs, 0, chs.length, target)]);
    }
}
