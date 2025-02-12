
package org.example;
import java.awt.*;
public class Scania extends Car implements LoadFunctionality {
    private final double velocityfatcor = 1.1;
    private double angle = 0.0;
    private int maxAngle = 70;
    private int minAngle = 0;

    public Scania(){
        super(2,0.9,0,Color.MAGENTA, "scania",6);
    }
    @Override protected double speedFactor(){
            return getEnginePower()*0.01*velocityfatcor;
        }

    @Override
    public void raise(double incrementDegrees){
    if (getCurrentSpeed() == 0 && angle + incrementDegrees <= maxAngle && incrementDegrees >= minAngle ){

        angle = incrementDegrees + angle;
    }
        
    }

    @Override
    public void lower(double decrementDegrees){
    if (getCurrentSpeed() == 0 && angle - decrementDegrees >= minAngle && decrementDegrees < maxAngle ){
        angle = angle - decrementDegrees;
    }
        
    }

    @Override
    public double getAngle(){
        return angle;
    }

    @Override
    public void gas(double amount) {
        if (amount > 0 && amount < 1 && getAngle() == 0) {
                    incrementSpeed(amount);
        }
    }
    @Override
    public void brake(double amount) {
        if (amount > 0 && amount < 1 && getAngle() == 0) {
                decrementSpeed(amount);
        }
    }

    public int getMaxAngle(){
        return maxAngle;
    }

    public int getMinAngle(){
        return minAngle;
    }

}
