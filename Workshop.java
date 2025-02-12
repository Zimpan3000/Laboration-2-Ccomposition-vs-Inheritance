
package org.example;
import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car>{

    private int capacity;
    private List<T> workshopList= new ArrayList<>(capacity);
    private Class<T> type;

    public Workshop(int capacity, Class<T> type){
        this.capacity = capacity;
        this.type = type;
    }

    public <S extends Car> void fixCar(S damagedCar){
        if (!type.isInstance(damagedCar)) {
            throw new IllegalArgumentException("This workshop only accepts " + type.getSimpleName() + " cars!");
        }
        if ( workshopList.size() < capacity) {
            workshopList.add((T) damagedCar);
        }
    } 

    public T removeCar(T car) {
        if (!workshopList.contains(car)) {
            System.out.println("This car is not in the workshop");
            return null;
        }
        workshopList.remove(car);
        return car;

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
