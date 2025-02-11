import java.util.ArrayList;
import java.util.List;

public class Workshop<T>{

    private int capacity;
    private T model;
    private List<T> workshopList= new ArrayList<>(capacity);

    public Workshop(int capacity, T model){
        this.capacity = capacity;
        this.model = model;
    }

    public void fixCar(T damagedGood){
        if ( workshopList.size() < capacity){
        workshopList.add(damagedGood);
    }
    } 

    public T removeCar(T car) {
        workshopList.remove(car);
        return car;

    }

    public T getmodelname() {
        return this.model;
    }

    public List<T> getWorkshopList() {
        return new ArrayList<>(workshopList); 
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return workshopList.size();
    }
}