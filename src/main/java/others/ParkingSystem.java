package others;

/**
 * @author: suruomo
 * @date: 2021/3/19 10:10
 * @description:
 */
public class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
       if (carType==1){
           if (big>0){
               big--;
               return true;
           }
       }else if (carType==2){
           if (medium>0){
               medium--;
               return true;
           }
       }else if (carType==3){
           if (small>0){
               small--;
               return true;
           }
       }
       return false;
    }
}
