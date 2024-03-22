public class Tanker extends CargoShip {

    @Override
    public void sail() {
        System.out.println("Tanker is sailing");
    }

    @Override
    public void loadCargo() {
        System.out.println("Tanker is loading cargo");
    }

    public Tanker(int load) {
        super(load);
    }
}
