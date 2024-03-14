import transport.Car;
import transport.CarManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CarManager carManager = new CarManager();
        carManager.addCar(new Car(1, "Toyota", "Corolla", 2010, "Red", 15000, "1234AB"));
        carManager.addCar(new Car(2, "Honda", "Civic", 2015, "Blue", 20000, "5678CD"));
        carManager.addCar(new Car(3, "Toyota", "Camry", 2018, "White", 25000, "9012EF"));

        ArrayList<Car> toyotaCars = carManager.getCarsByBrand("Toyota");
        System.out.println("Cars by brand Toyota:");
        for (Car car : toyotaCars) {
            System.out.println(car);
        }

        ArrayList<Car> oldCivicCars = carManager.getCarsByModelAndYears("Civic", 5);
        System.out.println("Older than 5 years Civic cars:");
        for (Car car : oldCivicCars) {
            System.out.println(car);
        }

        ArrayList<Car> expensive2018Cars = carManager.getCarsByYearAndPrice(2018, 20000);
        System.out.println("Expensive 2018 cars:");
        for (Car car : expensive2018Cars) {
            System.out.println(car);
        }
    }
}