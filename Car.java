import java.awt.*;
import java.util.HashMap;

public abstract class Car implements Moveable {
    // public final static double trimFactor = 1.25;  den här finns bara på volvo
    // public boolean turboOn; den här finns bara på saab

    private int nrDoors; // Number of doors on the car, these are private so that they can be accesed via getters and setters in the sub classes
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    private int widthOfCar;

    private HashMap<String, Double> dictionary = new HashMap<>();
    private Point direction = new Point(0,1);

    public  Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname, int widthOfCar){
        this.nrDoors = nrDoors; // uses this to refer to instance
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelname;
        this.widthOfCar = widthOfCar;

        dictionary.put("x", 0.0);
        dictionary.put("y", 0.0);
    }

    public int getwidthOfCar(){
        return widthOfCar;
    }

    public int getNrDoors(){
        return nrDoors; 
    }
    
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        double returnSpeed = currentSpeed;
        if (returnSpeed > enginePower) {
            returnSpeed = enginePower;
        } else if (returnSpeed < 0) {
            returnSpeed = 0;
        }
        return returnSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    this.color = clr;
    }

    public String getmodelname(){
        return modelName;
    }

    public void startEngine(){
        if( this instanceof flakfunktionalitet){
            flakfunktionalitet truck = (flakfunktionalitet) this;
            if (truck.getangle()== 0){
                currentSpeed = 0.1;
            }
        
        }
        else{
	    currentSpeed = 0.1;
        }
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    protected abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    
    public void gas(double amount) {
        if (amount > 0 && amount < 1) {
            if (this instanceof flakfunktionalitet) { // kollar om det finns ett flak
                flakfunktionalitet truck = (flakfunktionalitet) this;
                if (truck.getangle() == 0) {
                    incrementSpeed(amount);
                }
            } else {
                incrementSpeed(amount);
            }
        }
    }


    public void brake(double amount) {
        if (amount > 0 && amount < 1) {
            if (this instanceof flakfunktionalitet) { 
                flakfunktionalitet scania = (flakfunktionalitet) this;
                if (scania.getangle() == 0) {
                    decrementSpeed(amount);
                }
            } else {
                decrementSpeed(amount);
            }
        }
    }

    @Override
    public void move() {
        double speed = getCurrentSpeed();
        double x = speed * direction.x;
        double y = speed * direction.y;
        dictionary.put("y", dictionary.get("x") + x);
        dictionary.put("y", dictionary.get("y") + y);
    }

    @Override
    public void turnLeft() {
        switch (direction.y) {
            case 1:
                direction = new Point(-1,0);
    
            case 0:
                if (direction.x == -1) {
                     direction = new Point(0,-1);
                    
                } else if (direction.x == 1) {
                    direction = new Point(0,1);
                }
            case -1:
                direction = new Point(1,0);
                
             default:
                break;

        }
    
        
    }

    @Override
    public void turnRight() {
        switch (direction.y) {
            case 1:
                direction = new Point(1,0);
    
            case 0:
                if (direction.x == -1) {
                     direction = new Point(0,1);
                    
                } else if (direction.x == 1) {
                    direction = new Point(0,-1);
                }
            case -1:
                direction = new Point(-1,0);
                
             default:
                break;

        }
    }
    
}    

    

    
    
   
