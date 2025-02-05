import java.awt.*;
public class scania extends Car implements flakfunktionalitet {
    private final double velocityfatcor = 1.1;
    private double angle = 0.0;

    public scania(){
        super(2,0.9,10,Color.MAGENTA, "scania");
    }
    @Override protected double speedFactor(){
            return getEnginePower()*0.01*velocityfatcor;
        }

    @Override
    public void raise(double incrementdegrees){
    if (getCurrentSpeed() == 0 && angle + incrementdegrees <= 70 && incrementdegrees > 0 ){
        angle = incrementdegrees+ angle;
    }
        
    }

    @Override
    public void lower(double decrementdegrees){
    if (getCurrentSpeed() == 0 && angle - decrementdegrees >= 0 && decrementdegrees < 70 ){
        angle = angle - decrementdegrees;
    }
        
    }

    @Override
    public double getangle(){
        return angle;
    }
}