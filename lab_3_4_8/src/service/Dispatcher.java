package service;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Dispatcher {
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(0, driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public void addCar(Car car) {
        cars.add(0, car);
    }

    public Trip assignTrip(Trip trip) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).isAvailable()) {
                drivers.get(i).setAvailable(false);
                trip.setDriver(drivers.get(i));
                break;
            }
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).isAvailable()) {
                cars.get(i).setAvailable(false);
                trip.setCar(cars.get(i));
                break;
            }
        }
        if (trip.getCar() != null && trip.getDriver() != null) {
            System.out.println("Водитель " + trip.getDriver().getName() + " отправлен в рейс на автомобиле " + trip.getCar().getRegistrationNumber());
        } else {
            System.out.println("Не удалось назначить рейс. Водитель не доступен или автомобиль не найден.");
        }
        return trip;
    }

    public void suspendDriver(Driver driver) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == driver.getId()) {
                drivers.remove(i);
                break;
            }
        }
        System.out.println("Водитель " + driver.getName() + " уволен.");
    }
}


