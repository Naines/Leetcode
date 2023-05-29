class DesignParkingSystem{


    /**
     * 
     * 
     * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
    bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.
     */
    static class ParkingSystem {
        int big, medium, small;
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.small= small;
            this.medium=medium;
        }
        
        public boolean addCar(int carType) {

            switch(carType){
                case 1:
                    if(this.big==0) return false;
                    else this.big--;
                    return true;
                case 2:
                if(this.medium==0) return false;
                else this.medium--;
                return true;


                case 3:
                if(this.small==0) return false;
                    else this.small--;
                    return true;

                default:
                return false;
            }

        }
    }
    public static void main(String[] args) {

        int types[]={1,3,2,1,2,3,1,2,3,3,2,1};
        Car cars[]=new Car[types.length];
        
        for(int i=0;i<types.length;i++){
            cars[i]=new Car(types[i]);
        }



        
    }
    static class Car{
        int type;

        public Car(int type) {
            this.type = type;
        }
    }
}