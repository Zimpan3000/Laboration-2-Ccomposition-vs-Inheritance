package org.example;
import java.awt.*;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
public class TMF extends Car implements RampFunctionality {
    private final double fForce = 1.3;
    private boolean rampIsDown = true;
    private int maxsize = 5;
    private Deque<Car> carlist = new ArrayDeque<>(maxsize);
    private int widthOfLorry= 4;
    
    public TMF(){
        super(2, 0.8, 0,Color.CYAN ,"TMF",4);
        
    }

    private Boolean isCarClose(Car car) {
        Double diffX = Math.abs(car.getPositionX() - getPositionX());
        Double diffY = Math.abs(car.getPositionY() - getPositionY());
        Double diffXY = diffY + diffX;
        return(diffXY > 0 && diffXY <= 2);
    }

    public void loadCars(List<Car> loadList){

        if (loadList.size() + carlist.size() <= maxsize){
            for (Car car : loadList) {
                if (car.getWidthOfCar() <= widthOfLorry && !(car instanceof TMF)) {
                    if (isCarClose(car)) {
                        carlist.addFirst(car);
                       /* car.addPositionX(getPositionX());
                        car.addPositionY(getPositionY());*/
                    }
                }
            }
        }
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
        if (amount > 0 && amount < 1 && !rampIsDown) {
                incrementSpeed(amount);
        }
    }

    @Override
    public void changeRampIsDown(boolean status){
       if(currentSpeed == 0){ rampIsDown = status;}
    }

    @Override protected double speedFactor(){
        return getEnginePower()*0.01*fForce;
    }
    public boolean getRampIsDown(){
        return rampIsDown;
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

