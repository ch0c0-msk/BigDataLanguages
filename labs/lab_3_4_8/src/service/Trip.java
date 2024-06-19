package service;

public class Trip {
    private Car car;
    private Driver driver;

    public Trip() {
    }

    public Trip(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }
}


