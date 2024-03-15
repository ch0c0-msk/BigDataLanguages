import service.*;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Driver driver1 = new Driver("Вася");
        Driver driver2 = new Driver("Петя");
        dispatcher.addDriver(driver1);
        dispatcher.addDriver(driver2);

        Car car1 = new Car("Toyota", "ABC123");
        Car car2 = new Car("Honda", "XYZ789");
        dispatcher.addCar(car1);
        dispatcher.addCar(car2);

        Trip trip1 = new Trip();
        Trip trip2 = new Trip();

        trip1 = dispatcher.assignTrip(trip1);
        trip2 = dispatcher.assignTrip(trip2);

        trip1.getDriver().completeTrip(trip1, 90);
        trip2.getDriver().completeTrip(trip2, 90);

        dispatcher.suspendDriver(driver1);
        dispatcher.suspendDriver(driver2);

        Trip trip3 = new Trip();
        trip3 = dispatcher.assignTrip(trip3);
    }
}