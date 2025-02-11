
import java.awt.*;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
public class TMF extends Car implements rampfunctionalitet{
    private final double dragFactor = 1.3;
    private boolean rampStatus = true;
    private int maxsize = 5;
    private Deque<Car> carlist = new ArrayDeque<>(maxsize);
    private int widthOfLorry= 4;
    
    public TMF(){
        super(2, 0.8, 0,Color.CYAN ,"TMF",4);
        
    }

    public void loadCars(List<Car> loadList){
        if (loadList.size() + carlist.size() <= maxsize){
            for (int i = 0 ; i < loadList.size(); i++ ){
                if (loadList.get(i).getwidthOfCar() <= widthOfLorry && !(this instanceof TMF)&& isCarClose(loadList.get(i))) {
                carlist.addFirst(loadList.get(i));
                }
            }
        }
    }

    private Boolean isCarClose(Car car) {
        Double diffX = Math.abs(car.getPositionX() - getPositionX());
        Double diffY = Math.abs(car.getPositionY() - getPositionY());
        return(10 >= diffX && diffX > 1 && diffY > 1 && diffY <= 10);
    }
    
    public Car unloadCars() {
            return carlist.removeFirst();
        
    }
    @Override
    public void move() {
        super.move();
        for (Car car : carlist) {
            car.addPositionX(getPositionX());
            car.addPositionY(getPositionY());
            }
    }
   

   @Override 
   public void gas(double amount) {
        if (amount > 0 && amount < 1 && !rampStatus) {
                incrementSpeed(amount);
        }
    }

    @Override
    public void changerampstatus(boolean status){
       if(currentSpeed == 0){ rampStatus = status;}
    }

    @Override protected double speedFactor(){
        return getEnginePower()*0.01*dragFactor;
    }
    public boolean getrampstatus(){
        return rampStatus;
    }

    public int getmaxsize(){
        return maxsize;
    }

    public Deque<Car> getcarList(){
        return carlist;
    }

    public int widthOfLorry(){
        return widthOfLorry;
    }
}

