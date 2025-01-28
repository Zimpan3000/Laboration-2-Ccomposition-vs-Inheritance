import java.awt.*;

public class Saab95 extends Car {

   private double turbo = 1;
   private boolean turboOn = false;

    public Saab95(){
        super(4,0.5,10,Color.PINK,"Saab95");
    }
    
    /*public String getdirection(){
        return this.direction;
    }

    public void setDirection(String newDirection){
        this.direction = newDirection;
    }*/
   
    @Override
    public double speedFactor(){
        if(turboOn) this.turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
}