public class Test {
    public static void main(String[] args) {

        double p1=0.04,p2=0.16;
        double ans = Math.log(p1)+Math.log(p2);
        System.out.printf("%.5f",Math.pow(Math.E, ans) ); //0.0064
    }
}
