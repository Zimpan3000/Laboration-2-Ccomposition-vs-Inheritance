import java.awt.*;

public abstract class Car {
    // public final static double trimFactor = 1.25;  den här finns bara på volvo
    // public boolean turboOn; den här finns bara på saab

    private int nrDoors; // Number of doors on the car, these are private so that they can be accesed via getters and setters in the sub classes
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;

    public  Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelname){
        this.nrDoors = nrDoors; // uses this to refer to instance
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelname;
        

    }

    public int getNrDoors(){
        return nrDoors; 
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
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
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    protected abstract double speedFactor(); // is abstract so that it can be defined by sub classes this is because Volvo and saab have differernt speedfactors

    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
}    

    

    
    
   
