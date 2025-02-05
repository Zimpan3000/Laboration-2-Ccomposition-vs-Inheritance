
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class TMF extends Car {
    private final double dragFactor = 1.3;
    private boolean rampStatus = true;
    private List<Car> myList = new ArrayList<>();
    public TMF(){
        super(2, 0.8, 0,Color.CYAN , "TMF");
    }
}
