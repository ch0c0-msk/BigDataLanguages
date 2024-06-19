package transport;

import java.util.ArrayList;

public class CarManager {
    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public ArrayList<Car> getCarsByBrand(String brand) throws LongBrandNameException, CarNotFoundException {
        if (brand.length() > 30) {
            throw new LongBrandNameException();
        }
        ArrayList<Car> carsByBrand = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                carsByBrand.add(car);
            }
        }
        if (carsByBrand.isEmpty()) {
            throw new CarNotFoundException();
        }
        return carsByBrand;
    }

    public ArrayList<Car> getCarsByModelAndYears(String model, int years) throws CarNotFoundException {
        ArrayList<Car> carsByModelAndYears = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.getYearsInUse() > years) {
                carsByModelAndYears.add(car);
            }
        }
        if (carsByModelAndYears.isEmpty()) {
            throw new CarNotFoundException();
        }
        return carsByModelAndYears;
    }

    public ArrayList<Car> getCarsByYearAndPrice(int year, double price) {
        ArrayList<Car> carsByYearAndPrice = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                carsByYearAndPrice.add(car);
            }
        }
        return carsByYearAndPrice;
    }
}
