public abstract class CupBoard implements Furniture {
    int capacity;
    @Override
    public void display() {
        System.out.printf("Capacity of cupboard is: %d\n", capacity);
    }

    abstract void open();

    public CupBoard(int capacity) {
        this.capacity = capacity;
    }
}
