

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    

    public Volvo240(){
        super(4, 0.5, 10, Color.MAGENTA, "Volvo240");
    }
    
    
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
