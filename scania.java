import java.awt.*;
public class scania extends Car implements flakfunktionalitet {
    private final double velocityfatcor = 1.1;
    private double angle = 0.0;
    private int maxangle = 70;
    private int minangle = 0;

    public scania(){
        super(2,0.9,10,Color.MAGENTA, "scania",6);
    }
    @Override protected double speedFactor(){
            return getEnginePower()*0.01*velocityfatcor;
        }

    @Override
    public void raise(double incrementdegrees){
    if (getCurrentSpeed() == 0 && angle + incrementdegrees <= maxangle && incrementdegrees > minangle ){
        angle = incrementdegrees+ angle;
    }
        
    }

    @Override
    public void lower(double decrementdegrees){
    if (getCurrentSpeed() == 0 && angle - decrementdegrees >= minangle && decrementdegrees < maxangle ){
        angle = angle - decrementdegrees;
    }
        
    }

    @Override
    public double getangle(){
        return angle;
    }

    public int getmaxangle(){
        return maxangle;
    }

    public int getminangle(){
        return minangle;
    }

}