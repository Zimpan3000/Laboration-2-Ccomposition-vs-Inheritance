
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class TMF extends Car implements flakfunktionalitet{
    private final double dragFactor = 1.3;
    private boolean rampStatus = true;
    private int maxsize = 5;
    private List<Car> carlist = new ArrayList<>(maxsize);
    private int widthOfLorry= 4;
    private double angle = 0.0;
    public TMF(){
        super(2, 0.8, 0,Color.CYAN ,"TMF",4);
        
    }

    @Override public void raise(){

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

    public List<Car> getcarList(){
        return carlist;
    }

    public int widthOfLorry(){
        return widthOfLorry;
    }


}

