import java.math.BigDecimal;
import java.math.MathContext;

public class CheckIfItIsAStraightLine {

    static boolean check(int points[][], int n){
        double m=0.0;
        for(int i=0;i<n-1;i++){
            double temp=0.0;
            Double x=points[i][0]-points[i+1][0]*1.0;
            Double y=points[i][1]-points[i+1][1]*1.0;
            // System.out.println(x+" "+y);
            if(x==0.0) temp=Double.MAX_VALUE;
            else temp=divide(y,x);
            // System.out.println("calculated temp "+temp+" "+i);
            if(i!=0 && m!=temp) return false;
            m=temp;
            // System.out.println(m);
        }
        return true;
    }

    static boolean check2(int points[][], int n){
        int y0 = points[0][1] - points[1][1];
        int x0 = points[0][0] -  points[1][0];
        for(int i=1;i<n-1;i++){
            int y2=points[i][1] - points[i+1][1];
            int x2=points[i][0] - points[i+1][0];

            if(y0*x2!=x0*y2) return false;
        }
        return true;
    }

    //math transposition saves from using nasty if-else comments
    public static void main(String[] args) {
        int points[][]={{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        // int points[][]={{1,-8},{2,-3},{1,2}};//false
        // int points[][]={{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};//false
        // int points[][]={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}; //true
        int n=points.length;
        System.out.println(check(points, n));
        System.out.println(check2(points, n));

        // System.out.println(divide(5.0, 0.0));
    }


    //b/a
    static Double divide(Double a, Double b){
        BigDecimal ab = new BigDecimal(a);
        BigDecimal bb = new BigDecimal(b);
        MathContext mc = new MathContext(5);
        return ab.divide(bb, mc).doubleValue();
    }
}
