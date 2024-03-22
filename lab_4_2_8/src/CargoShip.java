public class CargoShip implements Ship {
    private int load;
    @Override
    public void sail() {
        System.out.println("CargoShip is sailing");
    }

    public void loadCargo() {
        System.out.println("CargoShip is loading");
    }

    public CargoShip(int load) {
        this.load = load;
    }
}
