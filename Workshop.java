import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Vehicle>{

    private int capacity;
    private Class<T> model;
    private List<T> workshopList= new ArrayList<>(capacity);

    public Workshop(int capacity, Class<T> model){
        this.capacity = capacity;
        this.model = model;
    }

    public <S extends Vehicle> void fixCar(S damagedVehicle){
        if (!model.isInstance(damagedVehicle)){
            throw new IllegalArgumentException(model.getSimpleName());
        }
        if ( workshopList.size() < capacity && !damagedVehicle.getOutOfOrder()){
        damagedVehicle.setOutOfOrderOn();
        workshopList.add((T) damagedVehicle);
    }
    } 

    public T remove(T Vehicle) {
        if (!model.isInstance(Vehicle))
        workshopList.remove(Vehicle);
        Vehicle.setOutOfOrderOff();
        return Vehicle;

    }

    public Class<T> getmodelname() {
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
