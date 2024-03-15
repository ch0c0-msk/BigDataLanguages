package service;

public class Driver {
    private static int counter = 1;
    private int id;
    private String name;
    private boolean available;

    public Driver(String name) {
        this.name = name;
        this.available = true;
        id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void requestRepair(Car car) {
        car.setAvailable(false);
        System.out.println(name + " запросил ремонт.");
    }

    public void completeTrip(Trip trip, int condition) {
        trip.getCar().setCondition(condition);
        trip.getCar().setAvailable(true);
        if (condition < 80) {
            requestRepair(trip.getCar());
        }
        trip.getDriver().setAvailable(true);
        System.out.println(name + " выполнил рейс на автомобиле " + trip.getCar().getRegistrationNumber());
    }
}
